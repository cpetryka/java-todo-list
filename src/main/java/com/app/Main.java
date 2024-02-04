package com.app;

import com.app.model.Comment;
import com.app.model.Project;
import com.app.model.status.Status;
import com.app.model.Task;
import com.app.model.User;
import com.app.repository.impl.UserRepositoryImpl;
import com.app.config.AppConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var emf = context.getBean("entityManagerFactory", EntityManagerFactory.class);

        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            var user = User
                    .builder()
                    .name("Adam")
                    .surname("Kowalski")
                    .email("adam@gmail.com")
                    .password("adam1234")
                    .build();

            var project = Project
                    .builder()
                    .name("Projekt 1")
                    .description("Opis projektu 1")
                    .startDate(LocalDate.of(2024, 1, 1))
                    .endDate(LocalDate.of(2024, 2, 1))
                    .user(user)
                    .build();

            var task1 = Task
                    .builder()
                    .title("Zadanie 1")
                    .description("Opis zadania 1")
                    .status(Status.NEW)
                    .startDate(LocalDate.of(2024, 1, 1))
                    .endDate(LocalDate.of(2024, 1, 2))
                    .project(project)
                    .build();
            em.persist(task1);

            var task2 = Task
                    .builder()
                    .title("Zadanie 2")
                    .description("Opis zadania 2")
                    .status(Status.IN_PROGRESS)
                    .startDate(LocalDate.of(2024, 1, 5))
                    .endDate(LocalDate.of(2024, 1, 8))
                    .project(project)
                    .build();
            em.persist(task2);

            var comment1 = Comment
                    .builder()
                    .content("Komentarz 1")
                    .creationDate(LocalDate.of(2024, 1, 1))
                    .user(user)
                    .task(task1)
                    .build();
            em.persist(comment1);

            var comment2 = Comment
                    .builder()
                    .content("Komentarz 2")
                    .creationDate(LocalDate.of(2024, 1, 2))
                    .user(user)
                    .task(task1)
                    .build();
            em.persist(comment2);

            var comment3 = Comment
                    .builder()
                    .content("Komentarz 3")
                    .creationDate(LocalDate.of(2024, 1, 3))
                    .user(user)
                    .task(task2)
                    .build();
            em.persist(comment3);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}