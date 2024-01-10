package cc.unitmesh.untitled.demo.dto;

import lombok.Data;

@Data
public class SetPaymentLimitRequest {
    private String accountId;
    private double paymentLimit;
}
