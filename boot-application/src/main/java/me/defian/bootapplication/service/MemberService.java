package me.defian.bootapplication.service;

import me.defian.bootapplication.dto.MemberCreateRequestDto;
import me.defian.bootapplication.dto.MemberDto;
import me.defian.bootapplication.entity.Member;
import me.defian.bootapplication.entity.Team;
import me.defian.bootapplication.repository.MemberRepository;
import me.defian.bootapplication.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    public MemberDto findById_MemberDto(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 값을 가진 데이터가 없습니다"));

        return MemberDto.builder()
                                .id(member.getId())
                                .age(member.getAge())
                                .name(member.getName())
                                .team(member.getTeam())
                                .build();
    }

    @Transactional
    public MemberDto create_Member(MemberCreateRequestDto memberCreateRequestDto) {

        Team team = teamRepository.findById(memberCreateRequestDto.getTeamId()).orElseThrow(() -> new IllegalArgumentException("해당 id값을 가진 Team 데이터가 없습니다."));



        Member saveMember = Member.builder()
                .age(memberCreateRequestDto.getAge())
                .name(memberCreateRequestDto.getName())
                .team(team)
                .build();
        Member savedMember = memberRepository.save(saveMember);
        return new MemberDto(savedMember);
    }
}
