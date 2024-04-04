package com.porto.passin.controllers;


import com.porto.passin.dto.event.EventIdDTO;
import com.porto.passin.dto.event.EventRequestDTO;
import com.porto.passin.dto.event.EventResponseDTO;
import com.porto.passin.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEvent(@PathVariable String id){
        EventResponseDTO event =  eventService.getEventDetail(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping()
    public ResponseEntity<EventIdDTO> createEvent(@RequestBody EventRequestDTO dto, UriComponentsBuilder uriComponentsBuilder){
        EventIdDTO eventIdDTO = this.eventService.createNewEvent(dto);

        var uri = uriComponentsBuilder.path("/events/{id}").buildAndExpand(eventIdDTO.eventID()).toUri();

        return ResponseEntity.created(uri).body(eventIdDTO);
    }
}
