package cc.unitmesh.untitled.demo.controller;

import cc.unitmesh.untitled.demo.service.MemberAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MemberEntityAccount")
public class MemberAccountController {
    @Autowired
    MemberAccountService memberAccountService;

    @GetMapping("/{accountId}/paymentLimit")
    public String getPaymentLimit(@PathVariable String accountId) {
        return memberAccountService.getPaymentLimitBy(accountId);
    }
}
