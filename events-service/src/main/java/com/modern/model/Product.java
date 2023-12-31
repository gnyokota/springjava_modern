package com.modern.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Document
public record Product(
        @Id
        String id,
        String eventId,
        String name,
        String description,
        BigDecimal price
) {
}
