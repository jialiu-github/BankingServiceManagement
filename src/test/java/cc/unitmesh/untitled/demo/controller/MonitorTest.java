package cc.unitmesh.untitled.demo.controller;

import cc.unitmesh.untitled.demo.dto.StepNumberDTO;
import cc.unitmesh.untitled.demo.service.MonitorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
public class MonitorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MonitorService monitorService;

    @Test
    public void shouldSaveStepNumbersSuccessfully() throws Exception {
        // 准备测试数据
        List<StepNumberDTO> stepNumbers = new ArrayList<>();
        StepNumberDTO stepNumber1 = new StepNumberDTO();
        stepNumber1.setStepNumber(5000);
        stepNumbers.add(stepNumber1);

        StepNumberDTO stepNumber2 = new StepNumberDTO();
        stepNumber2.setStepNumber(8000);
        stepNumbers.add(stepNumber2);

        // 确定模拟方法的行为
        doNothing().when(monitorService).saveStepNumbers(anyList());

        // 执行 POST 请求进行测试
        mockMvc.perform(post("/monitor/stepNumber")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(stepNumbers)))
                .andExpect(status().isCreated());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
