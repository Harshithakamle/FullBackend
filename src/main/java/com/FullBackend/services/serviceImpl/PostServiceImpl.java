package com.FullBackend.services.serviceImpl;

import com.FullBackend.entities.Category;
import com.FullBackend.entities.Post;
import com.FullBackend.entities.User;
import com.FullBackend.exceptions.ResourceNotFoundException;
import com.FullBackend.payloads.PostDto;
import com.FullBackend.repositories.CategoryRepository;
import com.FullBackend.repositories.PostRepository;
import com.FullBackend.repositories.UserRepository;
import com.FullBackend.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CategoryRepository catRepo;


    @Override
    public PostDto createPost(PostDto postDto, long userId, long categoryId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        Category category = catRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("user", "id", categoryId));
        Post post = mapper.map(postDto, Post.class);
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post newPost = postRepo.save(post);
        return mapper.map(newPost,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("user", "id", postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        Post updatedPost = postRepo.save(post);
        return mapper.map(updatedPost,PostDto.class);
    }

    @Override
    public void deletePost(long postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("user", "id", postId));
        postRepo.delete(post);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> allPosts = postRepo.findAll();
        List<PostDto> postDtos = allPosts.stream().map((posts) -> mapper.map(posts, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(long postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("user", "id", postId));
        return mapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getAllPostsByCategory(long catId) {
        Category category = catRepo.findById(catId).orElseThrow(() -> new ResourceNotFoundException("user", "id", catId));
        List<Post> byCategory = postRepo.findByCategory(category);
        List<PostDto> allPosts = byCategory.stream().map((posts) -> mapper.map(posts, PostDto.class)).collect(Collectors.toList());
        return allPosts;
    }

    @Override
    public List<PostDto> getAllPostsByUser(long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        List<Post> byUser = postRepo.findByUser(user);
        List<PostDto> collect = byUser.stream().map((users) -> mapper.map(users, PostDto.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return null;
    }
}
