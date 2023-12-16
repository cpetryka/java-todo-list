package com.app.repository;

import com.app.model.Task;
import com.app.repository.generic.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {}
