package cc.unitmesh.untitled.demo.service;

import cc.unitmesh.untitled.demo.dto.StepNumberDTO;
import cc.unitmesh.untitled.demo.entity.StepNumber;
import cc.unitmesh.untitled.demo.repository.StepNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MonitorService {
    @Autowired
    StepNumberRepository stepNumberRepository;

    public void saveStepNumbers(List<StepNumberDTO> stepNumbers) {
        List<StepNumber> newStepNumbers = stepNumbers.stream()
                .map(stepNumber -> new StepNumber(stepNumber.stepNumber, stepNumber.date, stepNumber.userId))
                .collect(Collectors.toList());
        stepNumberRepository.saveAll(newStepNumbers);
    }

    public List<StepNumberDTO> getStepNumbers() {
        Iterable<StepNumber> stepNumbers = stepNumberRepository.findAll();

        return StreamSupport.stream(stepNumbers.spliterator(), false)
                .map(stepNumber -> new StepNumberDTO(
                        stepNumber.getId(),
                        stepNumber.getStepNumber(),
                        stepNumber.getUserId(),
                        stepNumber.getDate()
                )).collect(Collectors.toList());
    }
}
