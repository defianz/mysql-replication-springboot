package me.defian.bootapplication.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private int age;

    private String name;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    private void changeTeam(Team changeTeam){
        if(team != null) team.getMembers().remove(this);
        team = changeTeam;
        if(team != null) team.getMembers().add(this);
    }
}
