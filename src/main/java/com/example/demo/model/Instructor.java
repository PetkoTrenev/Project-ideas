package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String info;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="instructor_course", joinColumns=@JoinColumn(name="instructor_id"), inverseJoinColumns=@JoinColumn(name="course_id"))
    public Set<Course> courses;
}
