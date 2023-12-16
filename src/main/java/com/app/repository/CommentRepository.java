package com.app.repository;

import com.app.model.Comment;
import com.app.repository.generic.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {}
