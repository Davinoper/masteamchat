package com.br.masteamchat.repository;

import com.br.masteamchat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = " SELECT u FROM User u "
            + " WHERE LOWER (u.email) LIKE %:searchTerm% ")
    User findByEmail(String searchTerm);
}
