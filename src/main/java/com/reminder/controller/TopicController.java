package com.reminder.controller;


import com.reminder.Dto.TagTopicDto;
import com.reminder.domain.Tag;
import com.reminder.domain.Topic;
import com.reminder.service.TagService;
import com.reminder.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topic")
public class TopicController {

    TopicService service;
    TagService tagService;

    @Autowired
    public TopicController(TopicService service, TagService tagService) {
        this.service = service;
        this.tagService = tagService;
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

    @PostMapping("/add-tag")
    public List<Topic> addTagToTopic(@RequestBody TagTopicDto tagTopic) {
        Optional<Topic> topicOptional = service.findById(tagTopic.getTopicId());

        if (!topicOptional.isEmpty()) {
            List<Tag> tags = new ArrayList<>();
            tags.add(tagService.findById(tagTopic.getTagId()).orElse(null));
            topicOptional.get().setTags(tags);
            service.saveTopic(topicOptional.get());
        }
        return service.findAllTopics();
    }

    @GetMapping("/tag/{tagId}")
    public List<Topic> findByTag(@PathVariable String tagId) {
        if(!tagService.findById(tagId).isEmpty()){
            return service.findByTagId(tagService.findById(tagId).get());
        }
        return null;
    }

}
