package com.app.repo;

import com.app.model.Comment;
import com.app.repo.generic.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {}
