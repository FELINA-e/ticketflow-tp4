package com.ticketflow.bookingservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookingRequest(
        @NotNull Long eventId,
        @NotBlank String customerName,
        @NotNull @Min(1) Integer numberOfSeats
) {
}
