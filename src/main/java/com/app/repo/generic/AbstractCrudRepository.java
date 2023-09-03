package com.app.repo.generic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AbstractCrudRepository<T, ID> implements CrudRepository<T, ID> {
    protected final EntityManagerFactory emf;

    private final Class<T> entityType = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    private final Class<ID> entityId = (Class<ID>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];

    @Override
    public Optional<T> save(T t) {
        EntityTransaction tx = null;
        Optional<T> op = Optional.empty();

        try (EntityManagerWrapper emw = new EntityManagerWrapper(emf)) {
            var em = emw.getEntityManager();
            tx = em.getTransaction();
            tx.begin();

            op = Optional.ofNullable(em.merge(t));

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        }

        return op;
    }

    @Override
    public List<T> saveAll(List<T> items) {
        EntityManager em = null;
        EntityTransaction tx = null;
        List<T> insertedItems = new ArrayList<>();

        try(var emw = new EntityManagerWrapper(emf)) {
            em = emw.getEntityManager();
            tx = em.getTransaction();
            tx.begin();

            for (var item : items) {
                insertedItems.add(em.merge(item));
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        }

        return insertedItems;
    }

    @Override
    public Optional<T> findById(ID id) {
        EntityManager em = null;
        EntityTransaction tx = null;
        Optional<T> op = Optional.empty();

        try(var emw = new EntityManagerWrapper(emf)) {
            em = emw.getEntityManager();
            tx = em.getTransaction();
            tx.begin();

            op = Optional.ofNullable(em.find(entityType, id));

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        }

        return op;
    }

    @Override
    public List<T> findAllById(List<ID> ids) {
        EntityManager em = null;
        EntityTransaction tx = null;
        List<T> items = new ArrayList<>();

        try(var emw = new EntityManagerWrapper(emf)) {
            em = emw.getEntityManager();
            tx = em.getTransaction();
            tx.begin();

            items = em
                    .createQuery(
                            "select t from %s t where t.id in :ids".formatted(entityType.getSimpleName()),
                            entityType)
                    .setParameter("ids", ids)
                    .getResultList();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        }

        return items;
    }

    @Override
    public List<T> findAll() {
        EntityManager em = null;
        EntityTransaction tx = null;
        List<T> items = new ArrayList<>();
        try(var emw = new EntityManagerWrapper(emf)) {
            em = emw.getEntityManager();
            tx = em.getTransaction();
            tx.begin();

            items = em
                    .createQuery("select t from %s t".formatted(entityType.getSimpleName()), entityType)
                    .getResultList();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        }

        return items;
    }

    @Override
    public Optional<T> deleteById(ID id) {
        EntityManager em = null;
        EntityTransaction tx = null;
        Optional<T> op = Optional.empty();

        try(var emw = new EntityManagerWrapper(emf)) {
            em = emw.getEntityManager();
            tx = em.getTransaction();
            tx.begin();

            var item = em.find(entityType, id);
            op = Optional.ofNullable(item);
            em.remove(item);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        }

        return op;
    }

    @Override
    public List<T> deleteAllById(List<ID> ids) {
        EntityManager em = null;
        EntityTransaction tx = null;
        List<T> items = List.of();
        try(var emw = new EntityManagerWrapper(emf)) {
            em = emw.getEntityManager();
            tx = em.getTransaction();
            tx.begin();

            items = em
                    .createQuery(
                            "select t from %s t where t.id in :ids".formatted(entityType.getSimpleName()),
                            entityType)
                    .setParameter("ids", ids)
                    .getResultList();

            for (var item : items) {
                em.remove(item);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        }

        return items;
    }
}
