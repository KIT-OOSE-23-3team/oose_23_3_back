package com.example.oose_23_3_back.membercontrol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findByIdentification(String id);
    Member findByPassword(String password);
    Member findByRentalPassword(String rentalPassword);
}