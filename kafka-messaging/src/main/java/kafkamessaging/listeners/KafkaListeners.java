package kafkamessaging.listeners;

import kafkamessaging.senders.KafkaStringSender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import kafkamessaging.model.SimpleModel;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaListeners {

    public final static String TOPIC_IN = "topic_IN";
    public final static String TOPIC_OUT = "topic_OUT";

    private final KafkaStringSender kafkaStringSender;

    @KafkaListener(topics = TOPIC_IN, containerFactory = "kafkaListenerContainerFactory")
    public void receiveIn(SimpleModel model) {
        log.info("received form topic '{}': {}", TOPIC_IN, model);

        log.info("received message: {}", model.getMessage());
        log.info("received description: {}", model.getDescription());

        kafkaStringSender.send(TOPIC_OUT, "result={Done}");
    }

    @KafkaListener(topics = TOPIC_OUT, containerFactory = "kafkaStringListenerContainerFactory")
    public void receiveOut(String data) {
        log.info("received form topic '{}': {}", TOPIC_OUT, data);
    }

}
