package com.FullBackend.services.serviceImpl;

import com.FullBackend.entities.Comment;
import com.FullBackend.entities.Post;
import com.FullBackend.exceptions.ResourceNotFoundException;
import com.FullBackend.payloads.CommentDto;
import com.FullBackend.repositories.CommentRepository;
import com.FullBackend.repositories.PostRepository;
import com.FullBackend.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository comRepo;
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PostRepository postRepo;

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("user", "id", postId));
        Comment comment = mapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment = comRepo.save(comment);
        return mapper.map(savedComment,CommentDto.class);
    }

    @Override
    public void deleteComment(long commentId) {
        Comment comment = comRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("user", "id", commentId));
        comRepo.delete(comment);
    }
}
