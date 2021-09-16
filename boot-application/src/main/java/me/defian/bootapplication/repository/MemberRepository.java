package me.defian.bootapplication.repository;

import me.defian.bootapplication.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
