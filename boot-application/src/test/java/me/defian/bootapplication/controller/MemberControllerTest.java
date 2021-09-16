package me.defian.bootapplication.controller;

import me.defian.bootapplication.dto.MemberCreateRequestDto;
import me.defian.bootapplication.dto.MemberDto;
import me.defian.bootapplication.entity.Member;
import me.defian.bootapplication.entity.Team;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberControllerTest {

    @Autowired
    MemberController memberController;

    @Autowired
    EntityManager em;

    private void insertMember(){
        Team teamA = Team.builder().name("TeamA").build();
        Team teamB = Team.builder().name("TeamB").build();
        em.persist(teamA);
        em.persist(teamB);

        for (int i = 0; i < 100; i++) {
            Team selectedTeam = i % 2 == 0 ? teamA : teamB;
            em.persist(Member.builder().name("member"+i).age(i).team(selectedTeam).build());
        }
        em.flush();
        em.clear();
    }

    @Test
    public void getMember(){
        insertMember();

        //given
        MemberDto member = memberController.getMember(10L);
        //when

        //then
        assertThat(member.getId()).isEqualTo(10);
        assertThat(member.getName()).isEqualTo("member7");
    }

    @Test
    public void createMember(){
        //given
        Team teamA = Team.builder().name("TeamA").build();
        Team teamB = Team.builder().name("TeamB").build();
        em.persist(teamA);
        em.persist(teamB);

        MemberCreateRequestDto memberCreateRequestDto = MemberCreateRequestDto.builder()
                .name("김형철")
                .age(10)
                .teamId(1L)
                .build();
        //when
        MemberDto member = memberController.createMember(memberCreateRequestDto);

        //then
        assertThat(member.getName()).isEqualTo("김형철");
        assertThat(member.getAge()).isEqualTo(10);
    }

}