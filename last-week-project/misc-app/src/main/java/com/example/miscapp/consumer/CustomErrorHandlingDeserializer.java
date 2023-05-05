package com.example.miscapp.consumer;

import com.example.miscapp.model.NumberPayload;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.stereotype.Component;

@Component
public class CustomErrorHandlingDeserializer extends ErrorHandlingDeserializer<NumberPayload> {
    @Override
    public NumberPayload deserialize(String topic, byte[] data) {
        if("dummy".equalsIgnoreCase(new String(data))) {
            System.out.println("XXXXXXXXX - Corrupt data: " + new String(data));
            NumberPayload numberPayload = new NumberPayload();
            numberPayload.setNumber(-111);
            return numberPayload;
        }
        return super.deserialize(topic, data);
    }
}
