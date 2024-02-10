package com.example.conferenceplanner.controller;

import com.example.conferenceplanner.model.Conference;
import com.example.conferenceplanner.service.ConferencePlannerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConferencePlannerControllerTest {

    @Mock
    private ConferencePlannerService conferencePlannerService;

    @InjectMocks
    private ConferencePlannerController conferencePlannerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createConference() {
        List<Conference> conferencesToCreate = Arrays.asList(
                new Conference(1L, "Conference 1", 60),
                new Conference(2L, "Conference 2", 90)
        );

        List<Conference> createdConferences = Arrays.asList(
                new Conference(1L, "Conference 1", 60),
                new Conference(2L, "Conference 2", 90)
        );

        Mockito.when(conferencePlannerService.saveConference(conferencesToCreate)).thenReturn(createdConferences);

        ResponseEntity<?> result = conferencePlannerController.createConference(conferencesToCreate);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(createdConferences, result.getBody());
        Mockito.verify(conferencePlannerService).saveConference(conferencesToCreate);
    }

    @Test
    void getAllConferences() {
        List<String> conferenceList = Arrays.asList(
                "Conference 1: 09:00 Conference 1 60min",
                "Conference 2: 10:00 Conference 2 90min"
        );

        Mockito.when(conferencePlannerService.getAllConferences()).thenReturn(conferenceList);

        ResponseEntity<?> result = conferencePlannerController.getAllConferences();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(conferenceList, result.getBody());
        Mockito.verify(conferencePlannerService).getAllConferences();
    }
}
