package com.example.oose_23_3_back.historycontrol.repository;

import com.example.oose_23_3_back.historycontrol.entity.HistoryCheck;
import com.example.oose_23_3_back.membercontrol.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface HistoryCheckRepository extends JpaRepository<HistoryCheck, Long> {
    List<HistoryCheck> findByMember(Member member);
    List<HistoryCheck> findByRentalTimeAfterAndReturnTimeBefore(LocalDateTime startDate, LocalDateTime endDate);
}
