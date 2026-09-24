package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String course_code;

    @Column(unique = true, nullable = false)
    private String semester;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private List<Assignment> assignments;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;




}
