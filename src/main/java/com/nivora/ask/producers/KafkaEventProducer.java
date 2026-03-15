package com.nivora.ask.producers;


import com.nivora.ask.config.KafkaConfig;
import com.nivora.ask.events.ViewCountEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaEventProducer {

    private final KafkaTemplate<String,Object> kafkaTemplate;

    public void publishViewCountEvent(ViewCountEvent viewCountEvent) {

        kafkaTemplate.send(
                KafkaConfig.TOPIC_NAME,
                String.valueOf(viewCountEvent.getTargetId()),
                viewCountEvent
        ).whenComplete((result,error) -> {
            if (error != null){
                System.out.println("Error Publishing view count Event: " + error.getMessage());
            }
        });

    }


}
