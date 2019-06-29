package com.alaorden.repository;

import com.alaorden.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNicknameEquals(String nickname);
    User findByEmailEquals(String email);
    User findByNicknameEqualsOrEmailEquals(String nickname,String email);
}
