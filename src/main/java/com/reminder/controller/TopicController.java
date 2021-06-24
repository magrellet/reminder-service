package com.reminder.controller;


import com.reminder.domain.Topic;
import com.reminder.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {

    TopicService service;

    @Autowired
    public TopicController(TopicService service){
        this.service = service;
    }

    @GetMapping
    public List<Topic> getTopics(){
        return service.findAllTopics();
    }

    @GetMapping("/{id}")
    public Topic getTopic(){
        Topic t = new Topic();
        return t.builder().title("test").tag("tagtest").quickNote("quick note").details("details").build();
    }

    @PostMapping
    public List<Topic> saveTopic(@RequestBody Topic topic){
        service.saveTopic(topic);
        return service.findAllTopics();
    }

    @PutMapping
    public Topic updateTopic(){
        Topic t = new Topic();
        return t.builder().title("test").tag("tagtest").quickNote("quick note").details("details").build();
    }

    @DeleteMapping
    public Topic deleteTopic(){
        Topic t = new Topic();
        return t.builder().title("test").tag("tagtest").quickNote("quick note").details("details").build();
    }

}
