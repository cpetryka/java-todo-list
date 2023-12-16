package com.app.repo.impl;

import com.app.model.Project;
import com.app.repo.generic.AbstractCrudRepository;
import com.app.repo.generic.CrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class ProjectRepositoryImpl extends AbstractCrudRepository<Project, Long> implements CrudRepository<Project, Long> {
    public ProjectRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
