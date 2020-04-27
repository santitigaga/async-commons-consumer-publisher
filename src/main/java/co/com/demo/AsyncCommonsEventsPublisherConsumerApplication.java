package co.com.demo;

import org.reactivecommons.async.impl.config.annotations.EnableDomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableMessageListeners;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDomainEventBus
@EnableMessageListeners
public class AsyncCommonsEventsPublisherConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncCommonsEventsPublisherConsumerApplication.class, args);
	}

}
