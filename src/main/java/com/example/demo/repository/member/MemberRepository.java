package com.example.demo.repository.member;

import com.example.demo.repository.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByEmailAndPassword(final String email, final String password);
}
