package com.FullBackend.services;

import com.FullBackend.entities.Post;
import com.FullBackend.payloads.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto,long userId,long categoryId);

    PostDto updatePost(PostDto postDto, long postId);

    void deletePost(long postId);

    List<PostDto> getAllPosts();

    PostDto getPostById(long postId);

    List<PostDto> getAllPostsByCategory(long catId);

    List<PostDto> getAllPostsByUser(long userId);
    //to search posts
    List<PostDto> searchPosts(String keyword);


}
