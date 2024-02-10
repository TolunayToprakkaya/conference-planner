package com.example.conferenceplanner.service;

import com.example.conferenceplanner.model.Conference;
import com.example.conferenceplanner.repository.ConferenceRepository;
import com.example.conferenceplanner.service.impl.ConferencePlannerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ConferencePlannerServiceTest {

    @Mock
    private ConferenceRepository conferenceRepository;

    @InjectMocks
    private ConferencePlannerServiceImpl conferencePlannerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveConference() {
        List<Conference> conferencesToSave = createConferenceList();

        List<Conference> savedConferences = createConferenceList();

        when(conferenceRepository.saveAll(ArgumentMatchers.anyList())).thenReturn(savedConferences);

        List<Conference> result = conferencePlannerService.saveConference(conferencesToSave);

        assertEquals(savedConferences, result);
        verify(conferenceRepository).saveAll(conferencesToSave);
    }

    @Test
    public void testGetAllConferences() {
        List<Conference> mockConferenceList = createConferenceList();

        when(conferenceRepository.findAll()).thenReturn(mockConferenceList);

        List<String> result = conferencePlannerService.getAllConferences();

        assertNotNull(result);
    }

    private List<Conference> createConferenceList() {
        return Arrays.asList(
                new Conference(1L, "Conference 1", 60),
                new Conference(2L,"Conference 2", 60),
                new Conference(3L,"Conference 3", 60),
                new Conference(4L,"Conference 4", 60),
                new Conference(5L,"Conference 5", 60),
                new Conference(6L,"Conference 6", 45),
                new Conference(7L,"Conference 7", 45),
                new Conference(8L,"Conference 8", 45),
                new Conference(9L,"Conference 9", 30),
                new Conference(10L,"Conference 10", 30),
                new Conference(11L,"Conference 11", 30),
                new Conference(12L,"Conference 12", 30),
                new Conference(13L,"Conference 13", 30),
                new Conference(14L,"Conference 14", 30),
                new Conference(15L,"Conference 15", 30),
                new Conference(16L,"Conference 16", 30),
                new Conference(17L,"Conference 17", 30),
                new Conference(18L,"Conference 18", 30),
                new Conference(19L,"Conference 19 lightning", 5))   ;
    }
}
