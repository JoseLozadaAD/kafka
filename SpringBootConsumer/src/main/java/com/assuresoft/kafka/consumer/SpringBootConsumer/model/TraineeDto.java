package com.assuresoft.kafka.consumer.SpringBootConsumer.model;

import lombok.*;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class TraineeDto {
  private String id;
  private String fullName;
  private float grade;
}
