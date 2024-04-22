package cc.unitmesh.untitled.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import cc.unitmesh.untitled.demo.service.MemberEntityAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(MemberController.class)
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberEntityAccountService memberEntityAccountService;

    @Test
    public void should_return_payment_limit_for_valid_account_id() throws Exception {
        // Given
        String accountId = "123";
        String expectedPaymentLimit = "1000";
        when(memberEntityAccountService.getPaymentLimitBy(accountId)).thenReturn(expectedPaymentLimit);

        // When
        mockMvc.perform(MockMvcRequestBuilders.get("/" + accountId + "/paymentLimit"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedPaymentLimit));

        // Then
        assertEquals(expectedPaymentLimit, memberEntityAccountService.getPaymentLimitBy(accountId));
    }

    @Test
    public void should_return_not_found_for_invalid_account_id() throws Exception {
        // Given
        String accountId = "456";
        when(memberEntityAccountService.getPaymentLimitBy(accountId)).thenReturn(null);

        // When
        mockMvc.perform(MockMvcRequestBuilders.get("/" + accountId + "/paymentLimit"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        // Then
        assertEquals(null, memberEntityAccountService.getPaymentLimitBy(accountId));
    }
}