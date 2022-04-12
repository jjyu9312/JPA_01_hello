package com.springwook.jpa_01_hello.jpa01;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Member extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "NAME_ID")
    private Long id;

    @Column(name = "USERNAME") // 데이터베이스와 컬럼명 매칭
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;


    // 1:N 양방향에 사용
    @ManyToOne
    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false) // 연관관계 주인처럼 만들었지만 읽기 전용 필드로 사용
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT") // 연결 테이블이 PK가 FK가 되는 구조로 사용됨
//    private List<Products> products = new ArrayList<>();
//    아래와 같이 사용 OneToMany + ManyToOne
    @OneToMany(mappedBy = "member")
    private List<MemberProduct> products = new ArrayList<>();

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

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    /*
    private Integer age;

    @Enumerated(EnumType.STRING) // 자바 Enum 타입과 매핑
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) // 자바 날짜 타입과 매핑
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "description")// Varchar를 넘어서는 큰 컨텐츠를 넣고 싶을 때 사용
    private String description;

    @Transient // DB와 매핑하고 싶지 않은 엔티티를 사용하고 싶을 때
    private int temp;

    public String getDescription() {
        return description;
    }

    public Member(){}
     */


}
