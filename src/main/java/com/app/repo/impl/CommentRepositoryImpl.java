package com.app.repo.impl;

import com.app.model.Comment;
import com.app.repo.generic.AbstractCrudRepository;
import com.app.repo.generic.CrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class CommentRepositoryImpl extends AbstractCrudRepository<Comment, Long> implements CrudRepository<Comment, Long> {
    public CommentRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
