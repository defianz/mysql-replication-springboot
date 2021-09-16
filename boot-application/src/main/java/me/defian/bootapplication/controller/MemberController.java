package me.defian.bootapplication.controller;

import me.defian.bootapplication.dto.MemberCreateRequestDto;
import me.defian.bootapplication.dto.MemberDto;
import me.defian.bootapplication.entity.Member;
import me.defian.bootapplication.repository.MemberRepository;
import me.defian.bootapplication.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/members/get/{id}")
    public MemberDto getMember(@PathVariable("id") Long id){
        return memberService.findById_MemberDto(id);
    }

    @PostMapping("/members/create")
    public MemberDto createMember(@RequestBody MemberCreateRequestDto memberCreateRequestDto){
        return memberService.create_Member(memberCreateRequestDto);
    }

}
