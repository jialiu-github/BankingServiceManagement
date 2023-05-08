package cc.unitmesh.untitled.demo.controller;

import cc.unitmesh.untitled.demo.service.OktService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OkrController {
    private OktService service;

    public OkrController(OktService service) {
        this.service = service;
    }

    // POST /teams/{teamId}/objectives
    // ObjectiveDTO: { "name": string, "description": string, "type": string }
    // ObjectiveResponse: { "id": string, "name": string, "description": string, "type": string }
}

