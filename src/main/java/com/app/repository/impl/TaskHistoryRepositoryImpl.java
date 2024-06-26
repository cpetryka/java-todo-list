package com.app.repository.impl;

import com.app.model.TaskHistory;
import com.app.repository.TaskHistoryRepository;
import com.app.repository.generic.AbstractCrudRepository;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TaskHistoryRepositoryImpl extends AbstractCrudRepository<TaskHistory, Long> implements TaskHistoryRepository {
    public TaskHistoryRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
