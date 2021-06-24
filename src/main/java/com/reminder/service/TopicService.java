package com.reminder.service;

import com.reminder.domain.Topic;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TopicService {

    public Optional<Topic> findById(String id);

    void saveTopic(Topic topic);

    List<Topic> findAllTopics();


}
