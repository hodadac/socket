package com.example.demo.repository.auth;

import com.example.demo.repository.auth.entity.Auth;
import com.example.demo.repository.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Auth,Long> {
    boolean existsByMember(Member member);
    Optional<Auth> findByRefreshToken(String refreshToken);
}
