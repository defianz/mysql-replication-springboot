package me.defian.bootapplication.dto;

import lombok.*;
import me.defian.bootapplication.entity.Member;
import me.defian.bootapplication.entity.Team;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberDto {

    private Long id;
    private int age;
    private String name;
    private Team team;

    public MemberDto(Member member){
        this.id = member.getId();
        this.age = member.getAge();
        this.name = member.getName();
        this.team = member.getTeam();
    }
}
