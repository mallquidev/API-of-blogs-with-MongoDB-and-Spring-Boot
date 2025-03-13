package com.mallquidev.blogwithmongodb.controllers;

import com.mallquidev.blogwithmongodb.dto.Blog;
import com.mallquidev.blogwithmongodb.services.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    //crear el blog
    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        Blog savedBlog = blogService.createBlog(blog);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBlog);
    }

    //obtener todo los blogs
    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        if(blogs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(blogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable String id) {
        Blog blog = blogService.getBlogById(id)
                .orElseThrow(()-> new IllegalStateException("Blog not found"));
        return ResponseEntity.status(HttpStatus.OK).body(blog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogById(@PathVariable String id) {
        blogService.deleteBlogById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlogById(@PathVariable String id, @RequestBody Blog blog) {
        Blog updateBlog = blogService.updateBlog(id, blog);
        return ResponseEntity.status(HttpStatus.OK).body(updateBlog);
    }

}
