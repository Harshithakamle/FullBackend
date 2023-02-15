package com.FullBackend.payloads;

import com.FullBackend.entities.Category;
import com.FullBackend.entities.Comment;
import com.FullBackend.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private String title;

    private String content;

    private Date addedDate;

    private CategoryDto category;

    private UserDto user;

    private Set<CommentDto> comments=new HashSet<>();


}
