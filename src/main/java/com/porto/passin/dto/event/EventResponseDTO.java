package com.porto.passin.dto.event;

import com.porto.passin.entities.Event;
import lombok.Getter;

@Getter
public class EventResponseDTO {

    EventDetailDTO event;

    public EventResponseDTO(Event event, Integer numberOfAttendees){
        this.event = new EventDetailDTO(event.getId(), event.getTitle(), event.getDetails(),  event.getSlug(), event.getMaximum_attendees(), numberOfAttendees);
    }

}
