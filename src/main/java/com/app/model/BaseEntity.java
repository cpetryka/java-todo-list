package com.app.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BaseEntity be = (BaseEntity) o;
        return id != null && Objects.equals(id, be.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
