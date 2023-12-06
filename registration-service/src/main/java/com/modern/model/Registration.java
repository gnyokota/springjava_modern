package com.modern.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public record Registration(
        @Id
        String id,

        String productId,
        String eventName,
        BigDecimal productPrice,
        String ticketCode,
        @NotBlank(message = "Attendee can not be empty")
        String attendeeName
) {
}
