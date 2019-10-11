package jmsmessaging.senders;

import jmsmessaging.domain.Message;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SenderService {

    private final JmsTemplate jmsTemplate;
    private final String QUEUE_IN;

    @Autowired
    public SenderService(JmsTemplate jmsTemplate, @Value("${queue_in}") String queue_in) {
        this.jmsTemplate = jmsTemplate;
        QUEUE_IN = queue_in;
    }

    @Scheduled(initialDelay = 100, fixedRate = 5000)
    public void sendValue() {
        Message message = Message.create("SOS");
        log.info("Sending message, id {}", message.getId());
        jmsTemplate.convertAndSend(QUEUE_IN, message);
    }

}
