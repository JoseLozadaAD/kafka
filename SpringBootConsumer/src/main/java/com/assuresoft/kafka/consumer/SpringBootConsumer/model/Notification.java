package com.assuresoft.kafka.consumer.SpringBootConsumer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notifications")
public class Notification {
  @Id
  @UuidGenerator
  private UUID id;
  private String traineeId;
  private String fullName;
  private float grade;
}
