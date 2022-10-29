package com.rest.api.repo;

import com.rest.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserJpaRepo extends JpaRepository<User, Long> {
    Optional<User> findByUid(String email); // 회원가입 시 가입한 이메일 조회를 위해 이 메서드 선

    Optional<User> findByUidAndProvider(String uid, String provider);
}