package com.ticketflow.bookingservice.service;

import com.ticketflow.bookingservice.client.EventClient;
import com.ticketflow.bookingservice.dto.BookingRequest;
import com.ticketflow.bookingservice.dto.BookingResponse;
import com.ticketflow.bookingservice.dto.EventResponse;
import com.ticketflow.bookingservice.entity.Booking;
import com.ticketflow.bookingservice.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final EventClient eventClient;

    public BookingService(BookingRepository bookingRepository, EventClient eventClient) {
        this.bookingRepository = bookingRepository;
        this.eventClient = eventClient;
    }

    public BookingResponse create(BookingRequest request) {

        // Vérifier l'existence de l'événement via OpenFeign
        EventResponse event = eventClient.getById(request.eventId());

        // Créer la réservation seulement si l'événement existe
        Booking booking = new Booking(
                request.eventId(),
                request.customerName(),
                request.numberOfSeats()
        );

        Booking saved = bookingRepository.save(booking);

        return new BookingResponse(
                saved.getId(),
                saved.getEventId(),
                event.title(),
                saved.getCustomerName(),
                saved.getNumberOfSeats(),
                saved.getBookingDate()
        );
    }
}
