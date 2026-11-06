package com.ticketflow.eventservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EventRequest(
        @NotBlank String title,
        String description,
        @NotBlank String location,
        @NotNull LocalDateTime eventDate,
        @NotNull @Min(1) Integer availableSeats
) {
}