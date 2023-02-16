package com.FullBackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.*;

@Entity
@Table(name="posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;
    @NotEmpty
    private String title;
    private String content;
    private Date addedDate;

    @ManyToOne
    @JoinColumn(name="category_Id")
    private Category category;
    @ManyToOne
    private User user;

    @OneToMany(mappedBy="post",cascade=CascadeType.ALL)
    private List<Comment> comments=new ArrayList<>();
}
