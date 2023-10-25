package com.br.masteamchat.repository;

import com.br.masteamchat.model.Message;
import com.br.masteamchat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = " SELECT m FROM Message m "
            + " WHERE (m.team.id) = :teamID ")
    List<Message> findByTeamId(Long teamID);

}
