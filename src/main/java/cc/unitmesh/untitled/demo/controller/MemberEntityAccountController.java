package cc.unitmesh.untitled.demo.controller;

import cc.unitmesh.untitled.demo.dto.AccountPaymentLimitDto;
import cc.unitmesh.untitled.demo.service.MemberEntityAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/MemberEntityAccount")
public class MemberEntityAccountController {
    @Autowired
    MemberEntityAccountService memberEntityAccountService;

    @PutMapping("/paymentLimit")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePaymentLimit(@RequestBody AccountPaymentLimitDto accountPaymentLimitDto) {
        memberEntityAccountService.updateAccount(accountPaymentLimitDto.accountId, accountPaymentLimitDto.paymentLimit);
    }

    @GetMapping("/{accountId}/paymentLimit")
    public String getPaymentLimit(@PathVariable String accountId) {
        return memberEntityAccountService.getPaymentLimitBy(accountId);
    }
}
