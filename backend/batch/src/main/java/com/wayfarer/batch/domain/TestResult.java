package com.wayfarer.batch.domain;


import javax.persistence.*;

@Entity
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private long testResultId;

    @Column
    private String skill;

    @Column
    private int count;
}
