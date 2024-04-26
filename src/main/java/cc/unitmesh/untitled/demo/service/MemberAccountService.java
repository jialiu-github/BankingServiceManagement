package cc.unitmesh.untitled.demo.service;

import cc.unitmesh.untitled.demo.repository.MemberAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberAccountService {
    @Autowired
    MemberAccountRepository memberAccountRepository;

    public String getPaymentLimitBy(String accountId) {
        return memberAccountRepository.findById(Long.parseLong(accountId)).get().getPaymentLimit().toString();
    }
}
