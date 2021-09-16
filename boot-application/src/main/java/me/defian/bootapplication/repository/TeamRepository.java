package me.defian.bootapplication.repository;

import me.defian.bootapplication.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
