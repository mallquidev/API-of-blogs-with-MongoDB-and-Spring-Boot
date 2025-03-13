package com.mallquidev.blogwithmongodb.services;

import com.mallquidev.blogwithmongodb.dto.Blog;
import com.mallquidev.blogwithmongodb.repositories.BlogRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    //crear un blog easy xd
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    //listar todo los blogs
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    //listar un blog por id
    public Optional<Blog> getBlogById(String id) {
        return blogRepository.findById(id);
    }

    //Delete un blog por id
    public void deleteBlogById(String id) {
        if(!blogRepository.existsById(id)){
            throw new IllegalStateException("Blog does not exist");
        }
        blogRepository.deleteById(id);
    }

    public Blog updateBlog(String id, Blog blogActualizado) {
        Blog blogExistente = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("El blog con id " + id + " no existe"));

        blogExistente.setTitle(blogActualizado.getTitle());
        blogExistente.setContent(blogActualizado.getContent());
        blogExistente.setCategory(blogActualizado.getCategory());
        blogExistente.setTags(blogActualizado.getTags());

        return blogRepository.save(blogExistente);
    }
}
