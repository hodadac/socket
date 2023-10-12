package com.example.demo.repository.member;

import com.example.demo.repository.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByName(final String name);

    Optional<Member> findByEmail(final String email);
}
