package com.modern.client;

import com.modern.model.Event;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface EventsClient {
    @GetExchange("/event")
    Event getEventByName(@RequestParam("name") String name);
}
