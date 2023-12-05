package com.assuresoft.kafka.provider.model;

import lombok.*;

import java.util.UUID;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TraineeDto {
  private UUID id;
  private String fullName;
  private float grade;
}
