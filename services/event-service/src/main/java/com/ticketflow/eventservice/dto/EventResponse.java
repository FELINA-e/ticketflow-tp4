package com.ticketflow.eventservice.dto;

import com.ticketflow.eventservice.entity.Event;
import java.time.LocalDateTime;

public record EventResponse(
        Long id,
        String title,
        String description,
        String location,
        LocalDateTime eventDate,
        Integer availableSeats
) {
    public static EventResponse from(Event event) {
        return new EventResponse(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getLocation(),
                event.getEventDate(),
                event.getAvailableSeats()
        );
    }
}
