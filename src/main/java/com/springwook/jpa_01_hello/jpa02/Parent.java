package com.springwook.jpa_01_hello.jpa02;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Parent {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name = "MEMBER_ID")) // 컬렉션을 저장하기 위한 별도의 테이블, MEMBER_ID를 외래키로 잡음
    @Column(name = "FOOD_NAME") // FOOD_NAME으로 컬럼을 만들어줌
    private Set<String> favoriteFoods = new HashSet<String>();

    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<Address>();

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true) // orphanRemoval이 있으면 부모 엔티티 컬렉션에서 빠진 자식 엔티티는 삭제
    private List<Child> childList = new ArrayList<>();

    // 양방향 연관관계용
    public void addChild(Child child) {
        childList.add(child);
        child.setParent(this);
    }
}
