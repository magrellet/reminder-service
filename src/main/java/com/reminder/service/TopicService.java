package com.reminder.service;

import com.reminder.domain.Tag;
import com.reminder.domain.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicService {

    Optional<Topic> findById(String id);

    void saveTopic(Topic topic);

    List<Topic> findAllTopics();


    void deleteTopic(Topic topic);

    List<Topic> findByTagId(Tag tag);
}
