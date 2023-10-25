package com.br.masteamchat.repository;

import com.br.masteamchat.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
