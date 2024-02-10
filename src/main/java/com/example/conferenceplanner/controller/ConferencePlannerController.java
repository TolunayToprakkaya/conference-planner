package com.example.conferenceplanner.controller;

import com.example.conferenceplanner.model.Conference;
import com.example.conferenceplanner.service.ConferencePlannerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/conference")
public class ConferencePlannerController {

    private final ConferencePlannerService conferencePlannerService;

    public ConferencePlannerController(ConferencePlannerService conferencePlannerService) {
        this.conferencePlannerService = conferencePlannerService;
    }

    @PostMapping("/createConference")
    public ResponseEntity<?> createConference(@RequestBody List<Conference> request) {
        return new ResponseEntity<>(conferencePlannerService.saveConference(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllConferences() {
        return ResponseEntity.ok(conferencePlannerService.getAllConferences());
    }

}
