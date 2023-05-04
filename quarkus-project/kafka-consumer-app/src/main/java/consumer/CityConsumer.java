package consumer;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class CityConsumer {

    @Incoming("city-in")
    public void processCity(String city) {
        System.out.println("****Received " + city);
    }
}
