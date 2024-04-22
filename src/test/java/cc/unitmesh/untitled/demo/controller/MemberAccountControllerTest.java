package cc.unitmesh.untitled.demo.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import cc.unitmesh.untitled.demo.dto.AccountPaymentLimitDto;
import cc.unitmesh.untitled.demo.service.MemberAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(YourController.class)
public class YourControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberAccountService memberAccountService;

    @Test
    public void testUpdatePaymentLimit() throws Exception {
        // Given
        AccountPaymentLimitDto accountPaymentLimitDto = new AccountPaymentLimitDto("12345", 1000.0);

        // When
        mockMvc.perform(put("/paymentLimit")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"accountId\":\"12345\",\"paymentLimit\":1000.0}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        // Then
        verify(memberAccountService, times(1)).updateAccount("12345", 1000.0);
    }
}