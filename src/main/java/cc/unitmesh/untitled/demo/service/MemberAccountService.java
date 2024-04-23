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

    public void updatePaymentLimit(String accountId, String paymentLimitValue) {
        //please implement this according to bussiness description
    }
}
