package com.mallquidev.blogwithmongodb.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "blog")
public class Blog {
    @Id
    private String id;

    private String title;
    private String content;
    private String category;
    private List<String> tags;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updateAt;
}

