package com.ticketflow.bookingservice.dto;

import java.time.LocalDateTime;

public record EventResponse(
        Long id,
        String title,
        String description,
        String location,
        LocalDateTime eventDate,
        Integer availableSeats
) {
}
