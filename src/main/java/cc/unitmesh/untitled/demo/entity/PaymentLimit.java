package cc.unitmesh.untitled.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="tw_payment_limit")
public class PaymentLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "account_id")
    private String accountId;
    
    @Column(name = "payment_limit")
    private double paymentLimit;
}