package streamcloud.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Payload {

    private UUID id;
    private LocalDateTime dateTime;
    private String text;

    private Payload() {
    }

    private Payload(UUID id, String text, LocalDateTime dateTime) {
        this.id = id;
        this.text = text;
        this.dateTime = dateTime;
    }

    public static Payload create(final String text) {
        return new Payload(UUID.randomUUID(), text, LocalDateTime.now());
    }

}
