package ru.itis.semesterwork.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.semesterwork.entities.User;
import ru.itis.semesterwork.security.token.Token;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    @Transactional
    @Query("select u from Token t inner join User u on t.user.id = u.id where t.token = :token ")
    Optional<User> findUserByToken(Token token);

}
