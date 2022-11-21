package com.example.myfamilyback.repository;

import com.example.myfamilyback.entities.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar,Long> {
}
