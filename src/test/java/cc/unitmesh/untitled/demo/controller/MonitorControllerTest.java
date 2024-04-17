package cc.unitmesh.untitled.demo.controller;

import cc.unitmesh.untitled.demo.dto.StepNumberDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MonitorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void saveStepNumbers_shouldReturnCreatedStatus() throws Exception {
        // given
        List<StepNumberDTO> stepNumbers = getStepNumbersDTO();
        // when
        mockMvc.perform(post("/stepNumber")
                .contentType("application/json")
                .content(asJsonString(stepNumbers)))
                // then
                .andExpect(status().isCreated());
    }

    private List<StepNumberDTO> getStepNumbersDTO() {
        // create and return a list of StepNumberDTO objects with sample data
        List<StepNumberDTO> stepNumbers = new ArrayList<>();
        StepNumberDTO stepNumber1 = new StepNumberDTO();
        stepNumber1.setId(1L);
        stepNumber1.setStepName("Step 1");
        stepNumber1.setStepValue(100);
        stepNumbers.add(stepNumber1);
        StepNumberDTO stepNumber2 = new StepNumberDTO();
        stepNumber2.setId(2L);
        stepNumber2.setStepName("Step 2");
        stepNumber2.setStepValue(200);
        stepNumbers.add(stepNumber2);
        return stepNumbers;
    }

    private String asJsonString(final List<StepNumberDTO> stepNumbers) {
        try {
            return new ObjectMapper().writeValueAsString(stepNumbers);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}