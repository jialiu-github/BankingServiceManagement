package cc.unitmesh.untitled.demo.controller;

import cc.unitmesh.untitled.demo.dto.AccountPaymentLimitDto;
import cc.unitmesh.untitled.demo.service.MemberAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/MemberEntityAccount")
public class MemberAccountController {
    @Autowired
    MemberAccountService memberAccountService;

    @PutMapping("/paymentLimit")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePaymentLimit(@RequestBody AccountPaymentLimitDto accountPaymentLimitDto) {
        memberAccountService.updatePaymentLimit(accountPaymentLimitDto.getAccountId(), accountPaymentLimitDto.getPaymentLimit());
    }

    @GetMapping("/{accountId}/paymentLimit")
    public String getPaymentLimit(@PathVariable String accountId) {
        return memberAccountService.getPaymentLimitBy(accountId);
    }
}
