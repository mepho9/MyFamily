package com.example.myfamilyback.dto;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class CalendarDTO {

    private Long calendarId;

    private String calendarName;

    private LocalDateTime creationDate;

    private String calendarPassword;

    private List<Long> memberList;
}
