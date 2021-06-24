package com.reminder.service;

import com.reminder.domain.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    List<Tag> findAllTags();

    Optional<Tag> findById(String id);

    void saveTag(Tag tag);

    void deleteTag(Tag tag);
}
