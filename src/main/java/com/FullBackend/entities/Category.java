package com.FullBackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinitions;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    private String categoryTitle;

    private String categoryDesciption;

    @OneToMany(mappedBy="category",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Post> posts=new ArrayList<>();

}
//category_desciption