package com.reminder.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "topic")
public class Topic {
    @Id
    private String id;
    private String title;
    private String tag;
    private String quickNote;
    private String details;
}
