package com.henrique.curso.plataforma.api.model.entity;

import com.henrique.curso.plataforma.api.model.enums.DifficultyEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "title", length = 50, nullable = false)
    private String courseTitle;
    @Column(name = "description", length = 200, nullable = false)
    private String courseDescription;
    @Column(name = "instructor", length = 50, nullable = false)
    private String instructor;
    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty", nullable = false)
    private DifficultyEnum difficulty;
    @ManyToMany(mappedBy = "course")
    private List<UserEntity> users;
}
