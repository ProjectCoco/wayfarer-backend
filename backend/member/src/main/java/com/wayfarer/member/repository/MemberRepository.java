package com.wayfarer.member.repository;

import com.wayfarer.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Boolean existsByUsername(String username);
    Optional<Member> findBySocialId(String socialId);
}
