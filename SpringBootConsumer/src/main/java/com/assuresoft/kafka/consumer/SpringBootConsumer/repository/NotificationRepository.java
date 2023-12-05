package com.assuresoft.kafka.consumer.SpringBootConsumer.repository;

import com.assuresoft.kafka.consumer.SpringBootConsumer.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {
}
