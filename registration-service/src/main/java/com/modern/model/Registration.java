package com.modern.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Registration(
        @Id
        Integer id,
        @NotNull
        Integer productId,
        @NotBlank(message = "Ticket code can not be empty")
        String ticketCode,
        @NotBlank(message = "Attendee can not be empty")
        String attendeeName
) {
}
