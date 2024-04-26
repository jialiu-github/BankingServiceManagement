package cc.unitmesh.untitled.demo.dto;

import lombok.Data;

@Data
public class UpdatePaymentLimitRequest {
    private Long accountId;
    private Double newLimit;
}