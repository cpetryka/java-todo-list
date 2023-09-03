package com.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "task_history")
public class TaskHistory extends BaseEntity {
    private String changeDescription;
    private LocalDate changeDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "task_id")
    private Task task;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;


}
