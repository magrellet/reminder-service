package com.reminder.repository;

import com.reminder.domain.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends MongoRepository<Topic, String> {
    Optional<Topic> findById(String id);
}
