package cc.unitmesh.untitled.demo.service;

import cc.unitmesh.untitled.demo.entity.MemberEntityAccount;
import cc.unitmesh.untitled.demo.repository.MemberEntityAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class MemberAccountService {
    @Autowired
    MemberEntityAccountRepository memberEntityAccountRepository;

    public String getPaymentLimitBy(String accountId) {
        return memberEntityAccountRepository.findById(Long.parseLong(accountId)).get().getPaymentLimit().toString();
    }

    public void updateAccount(String accountId, String paymentLimitValue) {
        Optional<MemberEntityAccount> accountOptional = memberEntityAccountRepository.findById(Long.parseLong(accountId));
        if (accountOptional.isEmpty()) {
            throw new IllegalAccountException();
        }

        MemberEntityAccount account = accountOptional.get();

        BigDecimal paymentLimit = checkPaymentLimit(paymentLimitValue, account);

        account.setPaymentLimit(paymentLimit);
        memberEntityAccountRepository.save(account);
    }

    private static BigDecimal checkPaymentLimit(String paymentLimitValue, MemberEntityAccount account) {
        try {
            BigDecimal paymentLimit = new BigDecimal(paymentLimitValue);
            if (account.getBalance().compareTo(paymentLimit) < 0) {
                throw new IllegalPaymentLimitException();
            }

            if (paymentLimit.compareTo(new BigDecimal(0) ) < 0) {
                throw new IllegalPaymentLimitException();
            }
            return paymentLimit;
        } catch (NumberFormatException e) {
            throw new IllegalPaymentLimitException();
        }
    }
}
