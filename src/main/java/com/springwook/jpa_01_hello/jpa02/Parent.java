package com.springwook.jpa_01_hello.jpa02;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Parent {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true) // orphanRemoval이 있으면 부모 엔티티 컬렉션에서 빠진 자식 엔티티는 삭제
    private List<Child> childList = new ArrayList<>();

    // 양방향 연관관계용
    public void addChild(Child child) {
        childList.add(child);
        child.setParent(this);
    }

}
