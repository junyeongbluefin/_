package y.o.c;

import org.springframework.cloud.servicebroker.service.events.EventFlowRegistries;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventFlowRegistriesConfiguration {

    @Bean
    public EventFlowRegistries eventFlowRegistries() {
        return new EventFlowRegistries();
    }
}
