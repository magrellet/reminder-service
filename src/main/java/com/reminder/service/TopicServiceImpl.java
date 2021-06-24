package com.reminder.service;

import com.reminder.domain.Tag;
import com.reminder.domain.Topic;
import com.reminder.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    TopicRepository repo;

    @Autowired
    public TopicServiceImpl(TopicRepository repo) {
        this.repo = repo;
    }

    @Override
    public Optional<Topic> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public void saveTopic(Topic topic) {
        try {
            repo.save(topic);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public List<Topic> findAllTopics() {
        return repo.findAll();
    }

    @Override
    public void deleteTopic(Topic topic) {
        repo.delete(topic);
    }

    @Override
    public List<Topic> findByTagId(Tag tag) {
        List<Topic> topics = repo.findAll();
        if (topics.isEmpty()) {
            return null;
        }
        return getFilteredTopicsByTags(topics, tag);
    }

    //TODO: Find how to do it with jpa or stream filter to handle nulls
    private List<Topic> getFilteredTopicsByTags(List<Topic> topics, Tag tag) {
        List<Topic> filteredTopics = new ArrayList<>();
        topics.forEach(topic -> {
            if (!Objects.isNull(topic.getTags())) {
                topic.getTags().forEach(innerTag -> {
                    if (innerTag.getId().equals(tag.getId()) && innerTag.getName().equals(tag.getName())) {
                        filteredTopics.add(topic);
                    }
                });
            }
        });
        return filteredTopics;
    }
}
