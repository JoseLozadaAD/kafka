package com.assuresoft.kafka.consumer.SpringBootConsumer.listeners;

import com.assuresoft.kafka.consumer.SpringBootConsumer.model.Notification;
import com.assuresoft.kafka.consumer.SpringBootConsumer.model.TraineeDto;
import com.assuresoft.kafka.consumer.SpringBootConsumer.repository.NotificationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
@RequiredArgsConstructor
public class KafkaConsumerListener {
  private final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerListener.class);
  private final NotificationRepository repository;

  @KafkaListener(topics = {"assuresoft-topic"}, groupId = "my-group-id")
  public void Listener(@Payload String data) {
    try {
      final ObjectMapper objectMapper = new ObjectMapper();
      final TraineeDto traineeDto = objectMapper.readValue(data, TraineeDto.class);

      final Notification notification = Notification
          .builder()
          .traineeId(traineeDto.getId())
          .grade(traineeDto.getGrade())
          .fullName(traineeDto.getFullName())
          .build();

      LOGGER.warn("Notification: " + traineeDto.getFullName() + " your new grade is '" + traineeDto.getGrade() + "'");
      repository.save(notification);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
