package me.defian.bootapplication.controller;


import lombok.RequiredArgsConstructor;
import me.defian.bootapplication.entity.Member;
import me.defian.bootapplication.entity.Team;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Profile("local")
@Component
@RequiredArgsConstructor
public class InitMember {

    private final InitMemberService initMemberService;

    @PostConstruct
    public void init(){
        initMemberService.init();
    }

    @Component
    static class InitMemberService {
        @PersistenceContext
        EntityManager em;

        @Transactional
        public void init(){
            Team teamA = Team.builder().name("TeamA").build();
            Team teamB = Team.builder().name("TeamB").build();
            em.persist(teamA);
            em.persist(teamB);

            for (int i = 0; i < 100; i++) {
                Team selectedTeam = i % 2 == 0 ? teamA : teamB;
                em.persist(Member.builder().name("member"+i).age(i).team(selectedTeam).build());
            }

        }
    }
}
