package com.example.aucaregistration.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "teacher_table")
public class Teacher {
    @Id
    @Column(name = "teacher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    @Enumerated(EnumType.STRING)
    private EQualification qualification;

    public Teacher() {
    }

    public Teacher(String code, String name, EQualification qualification) {
        this.code = code;
        this.name = name;
        this.qualification = qualification;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EQualification getQualification() {
        return qualification;
    }

    public void setQualification(EQualification qualification) {
        this.qualification = qualification;
    }
}