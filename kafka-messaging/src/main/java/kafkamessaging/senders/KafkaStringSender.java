package kafkamessaging.senders;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaStringSender {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String data) {
        log.info("sending data: {}", data);
        kafkaTemplate.send(topic, data);
    }
}
