package com.ticketflow.bookingservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;

    private String customerName;

    private Integer numberOfSeats;

    private LocalDateTime bookingDate;

    public Booking() {
    }

    public Booking(Long eventId, String customerName, Integer numberOfSeats) {
        this.eventId = eventId;
        this.customerName = customerName;
        this.numberOfSeats = numberOfSeats;
        this.bookingDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Long getEventId() {
        return eventId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }
}
