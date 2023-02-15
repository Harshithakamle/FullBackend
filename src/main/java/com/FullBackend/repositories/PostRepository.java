package com.FullBackend.repositories;

import com.FullBackend.entities.Category;
import com.FullBackend.entities.Post;
import com.FullBackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostRepository  extends JpaRepository<Post,Long> {

    List<Post> findByUser(User post);
    List<Post> findByCategory(Category category);
}
