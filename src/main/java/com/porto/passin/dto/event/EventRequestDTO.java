package com.porto.passin.dto.event;

public record EventRequestDTO(
        String title,
        String details,
        Integer maximumAttendees
        ) {
}
