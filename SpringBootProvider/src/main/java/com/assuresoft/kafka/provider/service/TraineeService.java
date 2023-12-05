package com.assuresoft.kafka.provider.service;

import com.assuresoft.kafka.provider.model.Trainee;
import com.assuresoft.kafka.provider.model.TraineeDto;
import com.assuresoft.kafka.provider.repository.TraineeRepository;
import com.assuresoft.kafka.provider.utils.Constants;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class TraineeService {
  private final TraineeRepository repository;
  private final KafkaTemplate<String, Object> kafkaTemplate;
  private static final Logger LOGGER = LoggerFactory.getLogger(TraineeService.class);

  public Trainee save(Trainee trainee) {
    return repository.save(trainee);
  }

  public Trainee getById(UUID id) {
    if (!repository.existsById(id)) {
      throw new EntityNotFoundException(String.format("Trainee with %s not found", id));
    }

    return repository.findById(id).get();
  }

  public Trainee updateGradeById(UUID id, Trainee trainee) {
    final Trainee traineeToUpdate = getById(id);
    traineeToUpdate.setGrade(trainee.getGrade());

    final TraineeDto traineeDto = TraineeDto
        .builder()
        .id(id)
        .fullName(traineeToUpdate.getName() + " " + traineeToUpdate.getLastname())
        .grade(traineeToUpdate.getGrade())
        .build();

    kafkaTemplate.send(Constants.TOPIC, traineeDto);

    return repository.save(traineeToUpdate);
  }
}
