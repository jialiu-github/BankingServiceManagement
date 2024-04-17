package cc.unitmesh.untitled.demo.controller;

import cc.unitmesh.untitled.demo.dto.StepNumberDTO;
import cc.unitmesh.untitled.demo.service.MonitorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MonitorController.class)
public class MonitorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MonitorService monitorService;

    @Test
    public void should_save_step_numbers() throws Exception {
        StepNumberDTO stepNumber1 = new StepNumberDTO(1L, 1000, UUID.randomUUID(), LocalDate.now());
        StepNumberDTO stepNumber2 = new StepNumberDTO(2L, 1500, UUID.randomUUID(), LocalDate.now());
        List<StepNumberDTO> stepNumbers = Arrays.asList(stepNumber1, stepNumber2);

        mockMvc.perform(MockMvcRequestBuilders.post("/monitor/stepNumber")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[{\"id\":1,\"stepNumber\":1000,\"userId\":\"" + stepNumber1.getUserId() + "\",\"date\":\"" + stepNumber1.getDate() + "\"}," +
                        "{\"id\":2,\"stepNumber\":1500,\"userId\":\"" + stepNumber2.getUserId() + "\",\"date\":\"" + stepNumber2.getDate() + "\"}]"))
                .andExpect(status().isCreated());

        verify(monitorService).saveStepNumbers(stepNumbers);
    }

    @Test
    public void should_get_step_numbers() throws Exception {
        StepNumberDTO stepNumber1 = new StepNumberDTO(1L, 1000, UUID.randomUUID(), LocalDate.now());
        StepNumberDTO stepNumber2 = new StepNumberDTO(2L, 1500, UUID.randomUUID(), LocalDate.now());
        List<StepNumberDTO> stepNumbers = Arrays.asList(stepNumber1, stepNumber2);

        when(monitorService.getStepNumbers()).thenReturn(stepNumbers);

        mockMvc.perform(MockMvcRequestBuilders.get("/monitor/stepNumber"))
                .andExpect(status().isOk());

        verify(monitorService).getStepNumbers();
    }
}