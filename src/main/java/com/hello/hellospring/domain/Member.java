package com.hello.hellospring.domain;

public class Member {
    private Long id; // 임의 고유 값
    private String name; // 사용자의 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
