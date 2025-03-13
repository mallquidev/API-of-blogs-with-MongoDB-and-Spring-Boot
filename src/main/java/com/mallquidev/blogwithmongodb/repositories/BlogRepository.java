package com.mallquidev.blogwithmongodb.repositories;

import com.mallquidev.blogwithmongodb.dto.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog, String> {

}
