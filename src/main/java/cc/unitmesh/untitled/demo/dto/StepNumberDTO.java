package cc.unitmesh.untitled.demo.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class StepNumberDTO {
    public Long id;
    public Integer stepNumber;

    public UUID userId;

    public LocalDate date;
    public StepNumberDTO(Long id, Integer stepNumber, UUID userId, LocalDate date) {
        this.id = id;
        this.stepNumber = stepNumber;
        this.userId = userId;
        this.date = date;
    }

    public StepNumberDTO(){}

}
