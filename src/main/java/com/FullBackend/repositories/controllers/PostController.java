package com.FullBackend.repositories.controllers;

import com.FullBackend.payloads.PostDto;
import com.FullBackend.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createThePost(@RequestBody PostDto postDto, @PathVariable long userId,
                                                 @PathVariable long categoryId){
        PostDto createdPostDto = postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createdPostDto, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getAllPostsByUser(@PathVariable long userId){
        List<PostDto> allPostsByUser = postService.getAllPostsByUser(userId);
        return new ResponseEntity<List<PostDto>>(allPostsByUser, HttpStatus.OK);
    }
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getAllPostsByCategory(@PathVariable long categoryId){
        List<PostDto> allPostsByCategory = postService.getAllPostsByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(allPostsByCategory, HttpStatus.OK);
    }
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        List<PostDto> allPosts = postService.getAllPosts();
        return new ResponseEntity<>(allPosts,HttpStatus.OK);
    }
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long postId){
        PostDto postById = postService.getPostById(postId);
        return new ResponseEntity<>(postById,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<?> deletePostById(@PathVariable long postId){
        postService.deletePost(postId);
        return new ResponseEntity<>("post deleted successfully", HttpStatus.OK);
    }
    @PutMapping("/update/{postId}")
    public ResponseEntity<PostDto> updateThePost(@RequestBody PostDto postDto,@PathVariable long postId){
        PostDto updatedPost = postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }
}
