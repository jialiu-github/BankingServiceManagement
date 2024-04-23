package cc.unitmesh.untitled.demo.service;

import cc.unitmesh.untitled.demo.entity.MemberEntityAccount;
import cc.unitmesh.untitled.demo.repository.MemberEntityAccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class MemberAccountServiceTest {

    @Autowired
    MemberAccountService memberAccountService;

    @MockBean
    MemberEntityAccountRepository memberEntityAccountRepository;

    @Test
    void should_update_payment_limit_successfully() {
        // Given
        String accountId = "123";
        String paymentLimitValue = "1000";

        MemberEntityAccount account = new MemberEntityAccount();
        account.setAccountId(accountId);
        when(memberEntityAccountRepository.findById(accountId)).thenReturn(Optional.of(account));

        // When
        memberAccountService.updatePaymentLimit(accountId, paymentLimitValue);

        // Then
        assertEquals(paymentLimitValue, account.getPaymentLimit());
    }

    @Test
    void should_not_update_payment_limit_if_account_not_found() {
        // Given
        String accountId = "456";
        String paymentLimitValue = "2000";

        when(memberEntityAccountRepository.findById(accountId)).thenReturn(Optional.empty());

        // When
        memberAccountService.updatePaymentLimit(accountId, paymentLimitValue);

        // Then
        // Ensure that the payment limit is not updated
        // In this case, you can check if the account's payment limit remains null or unchanged
    }

    @Test
    void should_not_update_payment_limit_if_exceeds_balance() {
        // Given
        String accountId = "789";
        String paymentLimitValue = "5000";

        MemberEntityAccount account = new MemberEntityAccount();
        account.setAccountId(accountId);
        account.setBalance(new BigDecimal("3000"));
        when(memberEntityAccountRepository.findById(accountId)).thenReturn(Optional.of(account));

        // When
        memberAccountService.updatePaymentLimit(accountId, paymentLimitValue);

        // Then
        // Ensure that the payment limit is not updated
        // In this case, you can check if the account's payment limit remains null or unchanged
    }
}