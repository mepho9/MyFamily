package com.example.myfamilyback.filter.calendar;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class InsertCalendar {

    private String calendarName;

    private LocalDateTime creationDate;

    private String calendarPassword;

    private List<Long> memberList;
}
