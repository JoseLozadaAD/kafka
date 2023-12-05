package com.assuresoft.kafka.provider.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trainees")
@EqualsAndHashCode(of = {"id", "email"})
public class Trainee {
  @Id
  @UuidGenerator
  private UUID id;
  private String name;
  private String lastname;
  private String email;
  private float grade;
}
