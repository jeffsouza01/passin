package com.porto.passin.dto.attendees;

import java.time.LocalDateTime;

public record AttendeeDetails(
        String id,
        String name,
        String email,
        LocalDateTime createdAt,
        LocalDateTime checkInAt

) {
}
