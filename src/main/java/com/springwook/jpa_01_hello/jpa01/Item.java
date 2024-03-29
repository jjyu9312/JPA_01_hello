package com.springwook.jpa_01_hello.jpa01;

import javax.persistence.*;

@Entity
// @Inheritance(strategy = InheritanceType.JOINED) // 조인 전략 사용 가능
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 단일 테이블 전략 사용 가능
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 구현 클래스 마다 테이블 전략 사용 가능 + 부모 클래스를 추상 클래스로 생성해야 함
@DiscriminatorColumn
public abstract class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
