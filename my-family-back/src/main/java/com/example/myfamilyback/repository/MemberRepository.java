package com.example.myfamilyback.repository;

import com.example.myfamilyback.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {
}
