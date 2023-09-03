package com.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@Entity
@Table(name = "projects")
public class Project extends BaseEntity {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "project", cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<Task> tasks = new ArrayList<>();
}
