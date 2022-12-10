package com.example.test.domain;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //ID 자동생성 전략

    @Column(name="username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }
}
