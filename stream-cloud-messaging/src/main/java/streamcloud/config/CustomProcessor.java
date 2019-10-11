package streamcloud.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface CustomProcessor {

    String INPUT = "input";

    @Input("input")
    SubscribableChannel input();

    String OUTPUT = "output";

    @Output("output")
    MessageChannel output();

    String OUTPUT_SCH = "output_sch";

    @Output("output_sch")
    MessageChannel anotherOutput();

}
