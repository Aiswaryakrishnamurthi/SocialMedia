package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(Post post) {
        postRepository.save(post);
        logger.info("Post created: {}", post);
    }

    public List<Post> getUserPosts(String username) {
        return postRepository.findByUsername(username);
    }

    public List<Post> getPostsByUsername(String username) {
        return postRepository.findByUsername(username);
    }

    public List<Post> findByUsername(String username) {
        List<Post> posts = postRepository.findByUsername(username);
        logger.info("Fetched {} posts for username: {}", posts.size(), username);
        return posts;
    }

    public void savePost(Post post, MultipartFile file, String username) throws IOException {
        String fileName = file.getOriginalFilename();
        String uploadDir = "uploads/";

        // Save image to file system
        file.transferTo(new File(uploadDir + fileName));

        // Set post attributes
        post.setImageUrl("/uploads/" + fileName);
        post.setUsername(username);

        // Save post to the database
        postRepository.save(post);
    }

    }
