package co.com.demo;

import lombok.RequiredArgsConstructor;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.api.domain.DomainEventBus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(value = "/events")
@RequiredArgsConstructor
public class ApiRest {

    private final DomainEventBus bus;

    @GetMapping
    public Mono<String> test(@RequestParam(name = "id") String fooId) {
        DomainEvent<String> event;
        event = new DomainEvent<>("sagarci.event", UUID.randomUUID().toString(), fooId);
        Mono.from(bus.emit(event)).subscribe();
        return Mono.just("Encolado: " + fooId);
    }
}
