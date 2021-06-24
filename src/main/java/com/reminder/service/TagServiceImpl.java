package com.reminder.service;

import com.reminder.domain.Tag;
import com.reminder.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    TagRepository repo;

    @Autowired
    public TagServiceImpl(TagRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Tag> findAllTags() {
        return repo.findAll();
    }

    @Override
    public Optional<Tag> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public void saveTag(Tag tag) {
        repo.save(tag);
    }

    @Override
    public void deleteTag(Tag tag) {
        repo.delete(tag);
    }
}
