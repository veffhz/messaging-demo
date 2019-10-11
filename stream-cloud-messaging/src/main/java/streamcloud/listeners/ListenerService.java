package streamcloud.listeners;

import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import streamcloud.config.CustomProcessor;
import streamcloud.domain.Payload;

@Slf4j
@Component
public class ListenerService {

    @StreamListener(CustomProcessor.OUTPUT)
    public void receiveMessage(Payload payload) {
        log.info("Received api message, id {}", payload.getId());
    }

    @StreamListener(CustomProcessor.OUTPUT_SCH)
    public void receiveSchMessage(Payload payload) {
        log.info("Received schedule message, id {}", payload.getId());
    }
}
