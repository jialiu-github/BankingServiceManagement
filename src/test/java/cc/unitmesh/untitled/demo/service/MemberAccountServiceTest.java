package cc.unitmesh.untitled.demo.service;

import cc.unitmesh.untitled.demo.entity.MemberEntityAccount;
import cc.unitmesh.untitled.demo.repository.MemberEntityAccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
class MemberAccountServiceTest {

    @Autowired
    MemberAccountService memberAccountService;

    @Autowired
    MemberEntityAccountRepository memberEntityAccountRepository;

    @Test
    void should_throwIllegalAccountException_when_accountNotFound() {
        // given
        String accountId = "999";

        // when
        // No need for explicit when as the method call will trigger the action

        // then
        assertThrows(IllegalAccountException.class, () -> memberAccountService.updateAccount(accountId, "100"));
    }

    @Test
    void should_updateAccountPaymentLimit_when_accountFound() {
        // given
        MemberEntityAccount account = new MemberEntityAccount();
        account.setId(1L);
        account.setPaymentLimit(new BigDecimal("50"));
        memberEntityAccountRepository.save(account);

        String accountId = account.getId().toString();
        String newPaymentLimit = "100";

        // when
        memberAccountService.updateAccount(accountId, newPaymentLimit);

        // then
        MemberEntityAccount updatedAccount = memberEntityAccountRepository.findById(account.getId()).orElse(null);
        assertNotNull(updatedAccount);
        assertEquals(new BigDecimal(newPaymentLimit), updatedAccount.getPaymentLimit());
    }

    @Test
    void should_notUpdateAccountPaymentLimit_when_invalidPaymentLimit() {
        // given
        MemberEntityAccount account = new MemberEntityAccount();
        account.setId(2L);
        account.setPaymentLimit(new BigDecimal("50"));
        memberEntityAccountRepository.save(account);

        String accountId = account.getId().toString();
        String invalidPaymentLimit = "abc"; // Invalid payment limit

        // when
        // No need for explicit when as the method call will trigger the action

        // then
        assertThrows(NumberFormatException.class, () -> memberAccountService.updateAccount(accountId, invalidPaymentLimit));

        MemberEntityAccount updatedAccount = memberEntityAccountRepository.findById(account.getId()).orElse(null);
        assertNotNull(updatedAccount);
        assertEquals(new BigDecimal("50"), updatedAccount.getPaymentLimit()); // Payment limit should remain unchanged
    }

    @Test
    void should_notUpdateAccountPaymentLimit_when_accountIdNotNumeric() {
        // given
        String invalidAccountId = "abc"; // Invalid account ID

        // when
        // No need for explicit when as the method call will trigger the action

        // then
        assertThrows(NumberFormatException.class, () -> memberAccountService.updateAccount(invalidAccountId, "100"));
    }
}