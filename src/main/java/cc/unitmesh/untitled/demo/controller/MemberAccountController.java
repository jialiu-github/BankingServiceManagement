package cc.unitmesh.untitled.demo.controller;

import cc.unitmesh.untitled.demo.dto.AccountPaymentLimitDto;
import cc.unitmesh.untitled.demo.service.MemberAccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/MemberEntityAccount")
public class MemberAccountController {
    @Autowired
    MemberAccountService memberAccountService;

    @GetMapping("/{accountId}/paymentLimit")
    public String getPaymentLimit(@PathVariable String accountId) {
        return memberAccountService.getPaymentLimitBy(accountId);
    }

    //update payment limit by account id

}
