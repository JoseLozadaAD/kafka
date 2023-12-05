package com.assuresoft.kafka.provider.controllers;

import com.assuresoft.kafka.provider.model.Trainee;
import com.assuresoft.kafka.provider.service.TraineeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/trainees")
@RequiredArgsConstructor
public class TraineeController {
  private final TraineeService service;

  @PostMapping
  public ResponseEntity<Trainee> save(@RequestBody Trainee trainee) {
    return ResponseEntity.ok(service.save(trainee));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Trainee> getById(@PathVariable UUID id) {
    return ResponseEntity.ok(service.getById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Trainee> update(@PathVariable UUID id, @RequestBody Trainee trainee) {
    return ResponseEntity.ok(service.updateGradeById(id, trainee));
  }
}
