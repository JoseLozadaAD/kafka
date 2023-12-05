package com.assuresoft.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfiguration {
  @Bean
  public NewTopic generateTopic() {
    final Map<String, String> configurations = new HashMap<>();
    configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // Delete the message
    configurations.put(TopicConfig.RETENTION_MS_CONFIG, "43200000"); // How long the message will remain in the server
    configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");
    configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "2097152"); // Size of the message

    return TopicBuilder.name("assuresoft-topic")
        .partitions(2)
        .replicas(2)
        .configs(configurations)
        .build();
  }
}
