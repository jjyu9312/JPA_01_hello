package com.springwook.jpa_01_hello.jpa01;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long teamId;

    private String name;

//    @OneToMany(mappedBy = "team")
//    private List<Member> members = new ArrayList<>();

    // 1:N 관계에서 연관관계 주인
    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<Member> members = new ArrayList<>();

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
