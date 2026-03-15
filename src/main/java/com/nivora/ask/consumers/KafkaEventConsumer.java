package com.nivora.ask.consumers;


import com.nivora.ask.config.KafkaConfig;
import com.nivora.ask.events.ViewCountEvent;
import com.nivora.ask.repo.QuestionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaEventConsumer {

    private  final QuestionRepo questionRepo;

    @KafkaListener(
            topics = KafkaConfig.TOPIC_NAME,
            containerFactory = "kafkaListenerContainerFactory"
    )
    public  void handleViewCount(ViewCountEvent viewCountEvent){

        questionRepo.findById(viewCountEvent.getTargetId())
                .flatMap(question -> {
                    Integer views = question.getViews();
                    question.setViews(views == null ? 0 : views + 1);
                    return questionRepo.save(question);
                })
                .subscribe(updatedQuestion -> {
                    System.out.println("View count increment for question " + updatedQuestion.getId());
                }, error -> {
                    System.out.println("Error incrementing view count for question: " + error.getMessage());
                });

    }
}
