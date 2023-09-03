package com.app.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Check;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "users")
@Check(constraints = "LENGTH(password) >= 8")
public class User extends BaseEntity {
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<TaskHistory> taskHistoryList = new ArrayList<>();
}
