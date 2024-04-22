package cc.unitmesh.untitled.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import cc.unitmesh.untitled.demo.service.MemberEntityAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class PaymentLimitControllerTest {

    @MockBean
    private MemberEntityAccountService memberEntityAccountService;

    private PaymentLimitController paymentLimitController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        paymentLimitController = new PaymentLimitController(memberEntityAccountService);
    }

    @Test
    public void testGetPaymentLimit() {
        // Given
        String accountId = "123";
        String expectedPaymentLimit = "1000";

        // When
        when(memberEntityAccountService.getPaymentLimitBy(accountId)).thenReturn(expectedPaymentLimit);
        String actualPaymentLimit = paymentLimitController.getPaymentLimit(accountId);

        // Then
        assertEquals(expectedPaymentLimit, actualPaymentLimit);
    }
}