package com.ticketflow.bookingservice.dto;

import java.time.LocalDateTime;

public record BookingResponse(
        Long id,
        Long eventId,
        String eventTitle,
        String customerName,
        Integer numberOfSeats,
        LocalDateTime bookingDate
) {
}
