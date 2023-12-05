package com.modern.spring.model;

public record Venue(
        int id,
        String name,
        String street,
        String city,
        String country
) {
}
