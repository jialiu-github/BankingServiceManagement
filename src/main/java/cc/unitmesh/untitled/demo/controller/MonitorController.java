package cc.unitmesh.untitled.demo.controller;

import cc.unitmesh.untitled.demo.dto.StepNumberDTO;
import cc.unitmesh.untitled.demo.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*Monitor监控功能，用于增量存储app记录的各项传感器数据，只支持查询GET和新增POST，不支持删除DELET和修改UPDATE*/
@RestController
@RequestMapping("/monitor")
public class MonitorController {
    @Autowired
    MonitorService monitorService;

    @PostMapping("/stepNumber")
    @ResponseStatus(HttpStatus.CREATED)
    public void stepNumber(@RequestBody List<StepNumberDTO> stepNumbers) {
        monitorService.saveStepNumbers(stepNumbers);
    }

    @GetMapping("/stepNumber")
    public List<StepNumberDTO> getStepNumbers() {
        return monitorService.getStepNumbers();
    }
}
