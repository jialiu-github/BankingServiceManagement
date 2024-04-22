package cc.unitmesh.untitled.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class AccountPaymentLimitDto {
    String accountId;
    String paymentLimit;
    Instant startTime;
    String updateStaffId;

    public AccountPaymentLimitDto(String accountId, String paymentLimit, Instant startTime, String updateStaffId) {
        this.accountId = accountId;
        this.paymentLimit = paymentLimit;
        this.startTime = startTime;
        this.updateStaffId = updateStaffId;
    }
    public AccountPaymentLimitDto() {

    }
}
