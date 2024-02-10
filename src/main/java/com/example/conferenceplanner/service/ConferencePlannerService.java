package com.example.conferenceplanner.service;

import com.example.conferenceplanner.model.Conference;

import java.util.List;

public interface ConferencePlannerService {

    List<Conference> saveConference(List<Conference> request);

    List<String> getAllConferences();
}
