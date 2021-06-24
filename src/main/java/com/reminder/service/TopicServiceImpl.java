package com.reminder.service;

import com.reminder.domain.Topic;
import com.reminder.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
