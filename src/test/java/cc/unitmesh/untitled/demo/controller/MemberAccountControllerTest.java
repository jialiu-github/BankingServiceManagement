package cc.unitmesh.untitled.demo.controller;

import cc.unitmesh.untitled.demo.dto.AccountPaymentLimitDto;
import cc.unitmesh.untitled.demo.service.MemberAccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Instant;

import static org.mockito.Mockito.verify;

@WebMvcTest(MemberAccountController.class)
public class MemberAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberAccountService memberAccountService;

    @Test
    public void should_update_payment_limit_successfully() throws Exception {
        // Given
        AccountPaymentLimitDto accountPaymentLimitDto = new AccountPaymentLimitDto("12345", "1000", Instant.now(), "staff123");

        // When
        mockMvc.perform(MockMvcRequestBuilders.put("/MemberEntityAccount/paymentLimit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(accountPaymentLimitDto)))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        // Then
        verify(memberAccountService).updatePaymentLimit(accountPaymentLimitDto.getAccountId(), accountPaymentLimitDto.getPaymentLimit());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}