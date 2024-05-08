package com.reindefox.homelibraryserver.repository;

import com.reindefox.homelibraryserver.model.Book;
import com.reindefox.homelibraryserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.login=:login")
    User findByLogin(@Param("login") String login);
}
