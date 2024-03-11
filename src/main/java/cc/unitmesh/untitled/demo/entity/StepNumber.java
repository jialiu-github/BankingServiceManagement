package cc.unitmesh.untitled.demo.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class StepNumber {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    private Integer stepNumber;
    @Getter
    private LocalDate date;

    @Getter
    private UUID userId;

    @CreatedDate
    private LocalDateTime createdAt;

    public StepNumber(Integer stepNumber, LocalDate date, UUID userId) {
        this.stepNumber = stepNumber;
        this.date = date;
        this.userId = userId;
    }

    public  StepNumber(){

    }
}
