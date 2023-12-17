package com.app.repository.impl;

import com.app.model.Project;
import com.app.repository.ProjectRepository;
import com.app.repository.generic.AbstractCrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class ProjectRepositoryImpl extends AbstractCrudRepository<Project, Long> implements ProjectRepository {
    public ProjectRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
