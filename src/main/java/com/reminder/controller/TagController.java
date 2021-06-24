package com.reminder.controller;

import com.reminder.domain.Tag;
import com.reminder.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tag")
public class TagController {

    TagService service;

    @Autowired
    public TagController(TagService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tag> getTags() {
        return service.findAllTags();
    }

    @GetMapping("/{id}")
    public Tag getTag(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public List<Tag> saveTag(@RequestBody Tag tag) {
        service.saveTag(tag);
        return service.findAllTags();
    }

    @DeleteMapping("/{id}")
    public List<Tag> deleteTag(@PathVariable String id) {
        Optional<Tag> tagOptional = service.findById(id);
        if (!tagOptional.isEmpty()) {
            service.deleteTag(tagOptional.get());
        }
        return service.findAllTags();
    }
}
