package streamcloud.senders;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import streamcloud.config.CustomProcessor;
import streamcloud.domain.Payload;

import java.util.Random;

@Slf4j
@Service
public class SenderService {

    private final MessageChannel channel;

    @Autowired
    public SenderService(CustomProcessor processor) {
        this.channel = processor.anotherOutput();
    }

    @Scheduled(initialDelay = 100, fixedRate = 5000)
    public void sendValue() {
        Message<Payload> message = MessageBuilder.withPayload(random()).build();
        log.info("Sending {}", message.getPayload().getText());
        channel.send(message);
    }

    private Payload random() {
        return Payload.create("schedule value " + new Random().nextInt());
    }

}
