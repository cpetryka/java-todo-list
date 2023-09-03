package com.app.model;

// Id (primary key)
//Treść
//Data utworzenia
//Id_Użytkownika (foreign key)
//Id_Zadania (foreign key)

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {
    private String content;
    private LocalDate creationDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "task_id")
    private Task task;
}
