package kafkamessaging.senders;

import kafkamessaging.model.SimpleModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaJsonSender {

    private final KafkaTemplate<String, SimpleModel> kafkaTemplate;

    public void send(String topic, SimpleModel model) {
        log.info("sending data: {}", model);
        kafkaTemplate.send(topic, model);
    }
}
