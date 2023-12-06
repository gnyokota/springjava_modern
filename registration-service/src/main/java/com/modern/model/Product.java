package com.modern.model;

import java.math.BigDecimal;

public record Product(
        String id,
        String eventId,
        String name,
        String description,
        BigDecimal price
) {
}
