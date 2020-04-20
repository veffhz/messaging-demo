package kafkamessaging.api;

import kafkamessaging.model.SimpleModel;
import kafkamessaging.senders.KafkaJsonSender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static kafkamessaging.listeners.KafkaListeners.TOPIC_IN;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SimpleController {

    private final KafkaJsonSender kafkaJsonSender;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/kafka")
    public void post(@RequestBody SimpleModel simpleModel) {
        log.info("controller receive: {}", simpleModel);
        kafkaJsonSender.send(TOPIC_IN, simpleModel);
    }

}
