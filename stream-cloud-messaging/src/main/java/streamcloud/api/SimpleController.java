package streamcloud.api;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import streamcloud.config.CustomProcessor;
import streamcloud.domain.Payload;

@Slf4j
@RestController
public class SimpleController {

    private final MessageChannel channel;

    @Autowired
    public SimpleController(CustomProcessor processor) {
        this.channel = processor.output();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/message")
    public String post(@RequestBody String text) {
        Message<Payload> message = MessageBuilder.withPayload(Payload.create(text)).build();
        log.info("Sending: {}", message.getPayload().getText());
        channel.send(message);
        return String.format("success, id {%s}", message.getPayload().getId());
    }

}
