package com.app.repository.impl;

import com.app.model.Comment;
import com.app.repository.CommentRepository;
import com.app.repository.generic.AbstractCrudRepository;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepositoryImpl extends AbstractCrudRepository<Comment, Long> implements CommentRepository {
    public CommentRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
