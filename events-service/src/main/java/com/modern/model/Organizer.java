package com.modern.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public record Organizer(
        String name,
        String description
) {
}
