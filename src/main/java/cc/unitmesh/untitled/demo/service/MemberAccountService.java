package cc.unitmesh.untitled.demo.service;

import cc.unitmesh.untitled.demo.repository.MemberEntityAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberAccountService {
    @Autowired
    MemberEntityAccountRepository memberEntityAccountRepository;

    public String getPaymentLimitBy(String accountId) {
        return memberEntityAccountRepository.findById(Long.parseLong(accountId)).get().getPaymentLimit().toString();
    }

}
