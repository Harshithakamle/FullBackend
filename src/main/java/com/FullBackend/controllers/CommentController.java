package com.FullBackend.controllers;

import com.FullBackend.entities.Comment;
import com.FullBackend.payloads.CommentDto;
import com.FullBackend.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService comService;

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable long postId){

        CommentDto savedcomment = comService.createComment(commentDto, postId);
        return new ResponseEntity<CommentDto>(savedcomment, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/comment/{commentId}")
   public ResponseEntity<?> deleteTheComment(@PathVariable long commentId) {
        comService.deleteComment(commentId);
        return new ResponseEntity<>("the Comment is Deleted..!!!",HttpStatus.OK);
    }
}