package com.reminder.controller;


import com.reminder.domain.Topic;
import com.reminder.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topic")
public class TopicController {

    TopicService service;

    @Autowired
    public TopicController(TopicService service) {
        this.service = service;
    }

    @GetMapping
    public List<Topic> getTopics() {
        return service.findAllTopics();
    }

    @GetMapping("/{id}")
    public Topic getTopic(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public List<Topic> saveTopic(@RequestBody Topic topic) {
        service.saveTopic(topic);
        return service.findAllTopics();
    }

    @PutMapping
    public List<Topic> updateTopic(@RequestBody Topic topic) {
        service.saveTopic(topic);
        return service.findAllTopics();

    }

    @DeleteMapping("/{id}")
    public List<Topic> deleteTopic(@PathVariable String id) {
        Optional<Topic> topicOptional = service.findById(id);
        if (!topicOptional.isEmpty()) {
            service.deleteTopic(topicOptional.get());
        }
        return service.findAllTopics();
    }

}
