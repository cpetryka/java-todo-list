package com.app.repository.impl;

import com.app.model.Comment;
import com.app.repository.generic.AbstractCrudRepository;
import com.app.repository.generic.CrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class CommentRepositoryImpl extends AbstractCrudRepository<Comment, Long> implements CrudRepository<Comment, Long> {
    public CommentRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
