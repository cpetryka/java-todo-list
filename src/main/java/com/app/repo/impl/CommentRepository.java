package com.app.repo.impl;

import com.app.model.Comment;
import com.app.repo.generic.AbstractCrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class CommentRepository extends AbstractCrudRepository<Comment, Long> {
    public CommentRepository(EntityManagerFactory emf) {
        super(emf);
    }
}
