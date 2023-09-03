package com.app.repo.generic;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
    Optional<T> save(T t);
    List<T> saveAll(List<T> items);
    Optional<T> findById(ID id);
    List<T> findAllById(List<ID> ids);
    List<T> findAll();
    Optional<T> deleteById(ID id);
    List<T> deleteAllById(List<ID> ids);
}