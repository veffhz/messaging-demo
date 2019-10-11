package streamcloud.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(CustomProcessor.class)
public class StreamConfig {
}
