package com.app.repository.impl;

import com.app.model.Project;
import com.app.repository.generic.AbstractCrudRepository;
import com.app.repository.generic.CrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class ProjectRepositoryImpl extends AbstractCrudRepository<Project, Long> implements CrudRepository<Project, Long> {
    public ProjectRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
