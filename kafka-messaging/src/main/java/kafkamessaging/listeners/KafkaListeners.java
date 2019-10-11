package kafkamessaging.listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import kafkamessaging.model.SimpleModel;
import kafkamessaging.senders.KafkaSender;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaListeners {

    public final static String TOPIC_IN = "topic_IN";
    public final static String TOPIC_OUT = "topic_OUT";

    private final ObjectMapper objectMapper;
    private final KafkaSender kafkaSender;

    @KafkaListener(topics = TOPIC_IN)
    public void receiveIn(String rawData) throws IOException {
        log.info("received form topic '{}': {}", TOPIC_IN, rawData);
        SimpleModel simpleModel = objectMapper.readValue(rawData, SimpleModel.class);

        log.info("received one: {}", simpleModel.getFieldOne());
        log.info("received two: {}", simpleModel.getFieldTwo());

        kafkaSender.send(TOPIC_OUT, "Done!");
    }

    @KafkaListener(topics = TOPIC_OUT)
    public void receiveOut(String rawData) {
        log.info("received form topic '{}': {}", TOPIC_OUT, rawData);
    }

}
