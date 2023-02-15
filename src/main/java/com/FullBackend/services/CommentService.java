package com.FullBackend.services;

import com.FullBackend.payloads.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, long postId);

    void deleteComment(long commentId);

}
