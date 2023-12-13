package com.app.repo.impl;

import com.app.model.Project;
import com.app.repo.generic.AbstractCrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class ProjectRepository extends AbstractCrudRepository<Project, Long> {
    public ProjectRepository(EntityManagerFactory emf) {
        super(emf);
    }
}