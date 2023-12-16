package com.app.repo;

import com.app.model.Task;
import com.app.repo.generic.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {}
