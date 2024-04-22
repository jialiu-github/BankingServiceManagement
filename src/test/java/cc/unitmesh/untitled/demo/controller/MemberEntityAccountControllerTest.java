package cc.unitmesh.untitled.demo.controller;

import cc.unitmesh.untitled.demo.dto.AccountPaymentLimitDto;
import cc.unitmesh.untitled.demo.service.MemberEntityAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PaymentLimitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberEntityAccountService memberEntityAccountService;

    @Test
    public void should_update_payment_limit_successfully() throws Exception {
        // Given
        AccountPaymentLimitDto accountPaymentLimitDto = new AccountPaymentLimitDto("12345", 1000);

        // When
        mockMvc.perform(MockMvcRequestBuilders.put("/paymentLimit")
                .contentType("application/json")
                .content("{\"accountId\":\"12345\",\"paymentLimit\":1000}")
        )
        // Then
        .andExpect(MockMvcResultMatchers.status().isNoContent());

        // Verify that the service method was called with the correct parameters
        verify(memberEntityAccountService).updateAccount("12345", 1000);
    }

    @Test
    public void should_fail_to_update_payment_limit_invalid_input() throws Exception {
        // Given
        AccountPaymentLimitDto accountPaymentLimitDto = new AccountPaymentLimitDto(null, 1000);

        // When
        mockMvc.perform(MockMvcRequestBuilders.put("/paymentLimit")
                .contentType("application/json")
                .content("{\"accountId\":null,\"paymentLimit\":1000}")
        )
        // Then
        .andExpect(MockMvcResultMatchers.status().isBadRequest());

        // Verify that the service method was not called
        verify(memberEntityAccountService, never()).updateAccount(anyString(), anyInt());
    }
}