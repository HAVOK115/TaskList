package com.HAVOK.TL_API.Repository;

import com.HAVOK.TL_API.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select u from User u where u.username = ?1")
    public List<User> getUsersByUserName(String username);

    @Query(value = "select u from User u where u.mail = ?1")
    public Optional<User> getUserByEmail(String email);
}
