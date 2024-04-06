package com.porto.passin.services;

import com.porto.passin.dto.attendees.AttendeesListDTO;
import com.porto.passin.entities.Attendee;
import com.porto.passin.repositories.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeService {

    @Autowired
    private AttendeeRepository attendeeRepository;

    public List<Attendee> getAllAttendesFromEvent(String eventID){
        return this.attendeeRepository.findByEventId(eventID);
    }


    public AttendeesListDTO getEventsAttendee(String eventID){
        List<Attendee> attendeeList = this.attendeeRepository.findByEventId(eventID);

    }
}
