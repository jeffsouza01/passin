package com.porto.passin.services;


import com.porto.passin.dto.event.EventIdDTO;
import com.porto.passin.dto.event.EventRequestDTO;
import com.porto.passin.dto.event.EventResponseDTO;
import com.porto.passin.entities.Attendee;
import com.porto.passin.entities.Event;
import com.porto.passin.repositories.AttendeeRepository;
import com.porto.passin.repositories.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AttendeeRepository attendeeRepository;

   @Transactional
    public EventResponseDTO getEventDetail(String eventId){
        Event event = this.eventRepository.findById(eventId).orElseThrow(
                () -> new RuntimeException("Event with ID: " + eventId + "Not Found!")
        );
        List<Attendee> attendeeList = this.attendeeRepository.findByEventId(eventId);

        return new EventResponseDTO(event, attendeeList.size());
    }


    @Transactional
    public EventIdDTO createNewEvent(EventRequestDTO dto){
        Event newEvent = new Event();

        newEvent.setTitle(dto.title());
        newEvent.setDetails(dto.details());
        newEvent.setMaximum_attendees(dto.maximumAttendees());
        newEvent.setSlug(createSlug(dto.title()));

        this.eventRepository.save(newEvent);

        return new EventIdDTO(newEvent.getId());
    }


    private String createSlug(String text){
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
                // Seleciona todos os acentos e substitui por string vazia
        return normalized.replaceAll("[\\p{InCOMBINING_DIACRITICAL_MARKS]", "")

                // Seleciona todos os caracteres alfanumericos, o que não for letra e numero
                .replaceAll("[^\\w\\s]", "")

                // Substitui todos os espaços vazios e coloca 1 hifen
                .replaceAll("\\s+", "-")
                .toLowerCase();
    }

}
