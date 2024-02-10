package com.example.conferenceplanner.service.impl;

import com.example.conferenceplanner.repository.ConferenceRepository;
import com.example.conferenceplanner.model.Conference;
import com.example.conferenceplanner.service.ConferencePlannerService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConferencePlannerServiceImpl implements ConferencePlannerService {

    private final ConferenceRepository conferenceRepository;

    public ConferencePlannerServiceImpl(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    @Override
    public List<Conference> saveConference(List<Conference> request) {
        return conferenceRepository.saveAll(request);
    }

    @Override
    public List<String> getAllConferences() {
        List<String> conferencePlan = new ArrayList<>();
        int trackNumber = 1;
        int morningSessionTime = 180;
        int afternoonSessionTime = 240;
        boolean isBeforeMidday = true;

        LocalDateTime now = LocalDateTime.now();

        List<Conference> conferenceList = conferenceRepository.findAll();
        conferenceList = conferenceList.stream()
                .sorted((o1, o2) -> Integer.compare(o2.getDuration(), o1.getDuration()))
                .collect(Collectors.toList());

        while (!conferenceList.isEmpty()) {
            List<Conference> trackConferenceList = new ArrayList<>();
            int remainingTime = morningSessionTime + afternoonSessionTime;

            for (Conference conference : conferenceList) {
                if (conference.getTitle().contains("lightning")) {
                    conference.setDuration(5);
                }

                if (conference.getDuration() <= remainingTime) {
                    trackConferenceList.add(conference);
                    remainingTime -= conference.getDuration();
                }

                if (remainingTime == 0) {
                    break;
                }
            }

            if (!trackConferenceList.isEmpty()) {
                LocalDateTime conferenceTime = LocalDateTime.now().withHour(9).withMinute(0).withSecond(0).withNano(0);

                conferencePlan.add("Track " + trackNumber + ":");

                for (Conference trackConference : trackConferenceList) {
                    if ((conferenceTime.plusMinutes(trackConference.getDuration()).isAfter(now.withHour(12).withMinute(0).withSecond(0).withNano(0)) ||
                            (conferenceTime.getHour() == 12 && conferenceTime.getMinute() == 0))
                            && isBeforeMidday) {
                        conferencePlan.add("12:00 Lunch");
                        conferenceTime = now.withHour(12).withMinute(0).withSecond(0).withNano(0);
                        conferenceTime = conferenceTime.plusMinutes(60);
                        isBeforeMidday = false;
                    }

                    String conferenceData = conferenceTime.toLocalTime() + " " + trackConference.getTitle() + " " + trackConference.getDuration() + "min";
                    conferencePlan.add(conferenceData);
                    conferenceTime = conferenceTime.plusMinutes(trackConference.getDuration());

                    conferenceList.remove(trackConference);
                }

                conferencePlan.add("17:00 Networking Event");
                isBeforeMidday = true;
                trackNumber++;
            } else {
                break;
            }
        }

        return conferencePlan;
    }

}
