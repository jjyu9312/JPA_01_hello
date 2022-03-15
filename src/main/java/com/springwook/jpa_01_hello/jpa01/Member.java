package com.springwook.jpa_01_hello.jpa01;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "NAME_ID")
    private Long id;

    @Column(name = "USERNAME") // 데이터베이스와 컬럼명 매칭
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    /*
    private Integer age;

    @Enumerated(EnumType.STRING) // 자바 Enum 타입과 매핑
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) // 자바 날짜 타입과 매핑
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Lob // Varchar를 넘어서는 큰 컨텐츠를 넣고 싶을 때 사용
    private String description;

    @Transient // DB와 매핑하고 싶지 않은 엔티티를 사용하고 싶을 때
    private int temp;

    public Member(){}
     */


}
