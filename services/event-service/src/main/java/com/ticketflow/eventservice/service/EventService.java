package com.ticketflow.eventservice.service;

import com.ticketflow.eventservice.dto.EventResponse;
import com.ticketflow.eventservice.entity.Event;
import com.ticketflow.eventservice.repository.EventRepository;
import org.springframework.stereotype.Service;
import com.ticketflow.eventservice.dto.EventRequest;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventResponse getById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Événement introuvable : " + id));

        return EventResponse.from(event);
    }
    public EventResponse create(EventRequest request) {
        Event event = new Event();

        event.setTitle(request.title());
        event.setDescription(request.description());
        event.setLocation(request.location());
        event.setEventDate(request.eventDate());
        event.setAvailableSeats(request.availableSeats());

        Event savedEvent = eventRepository.save(event);

        return EventResponse.from(savedEvent);
    }
}
