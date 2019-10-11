package kafkamessaging.api;

import kafkamessaging.model.SimpleModel;
import kafkamessaging.senders.KafkaSender;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static kafkamessaging.listeners.KafkaListeners.TOPIC_IN;


@Slf4j
@RequiredArgsConstructor
@RestController
public class SimpleController {

    private final KafkaSender kafkaSender;

    @GetMapping("/")
    public ResponseEntity<String> get() {
        log.info("received get");
        return ResponseEntity.ok("POST to /api/kafka");
    }

    @RequestMapping("/api/kafka")
    public void post(@RequestBody SimpleModel simpleModel) throws JsonProcessingException {
        log.info("controller receive: {}", simpleModel);
        kafkaSender.send(TOPIC_IN, simpleModel);
    }
}
