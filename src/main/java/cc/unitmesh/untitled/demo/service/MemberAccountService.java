package cc.unitmesh.untitled.demo.service;

import cc.unitmesh.untitled.demo.entity.MemberEntityAccount;
import cc.unitmesh.untitled.demo.repository.MemberEntityAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MemberAccountService {
    @Autowired
    MemberEntityAccountRepository memberEntityAccountRepository;

    public String getPaymentLimitBy(String accountId) {
        return memberEntityAccountRepository.findById(Long.parseLong(accountId)).get().getPaymentLimit().toString();
    }

    public void updateAccount(String accountId, String paymentLimit) {
        MemberEntityAccount account = memberEntityAccountRepository.findById(Long.parseLong(accountId)).get();
        account.setPaymentLimit(new BigDecimal(paymentLimit));
        memberEntityAccountRepository.save(account);
    }
}
