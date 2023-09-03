package com.app.model;

import com.app.model.status.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
    private String title;
    private String description;
    private Status status;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(mappedBy = "task", cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "task", cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<TaskHistory> taskHistoryList = new ArrayList<>();
}
