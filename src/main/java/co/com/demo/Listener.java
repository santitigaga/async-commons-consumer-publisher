package co.com.demo;

import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class Listener {
    @Bean
    public HandlerRegistry handlerRegistry(){
        return HandlerRegistry.register().listenEvent("sagarci.event",this::listenEvent,String.class);
    }

    private Mono<Void> listenEvent(DomainEvent<String> tDomainEvent) {
        System.out.println(tDomainEvent);
        return Mono.just(tDomainEvent.getData().toString()).then();
    }
}
