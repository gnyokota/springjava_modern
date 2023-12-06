package com.modern.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public record Event(
        @Id
        String id,
        String name,
        Organizer organizer,
        LocalDate startDate,
        LocalDate endDate
) {
}
