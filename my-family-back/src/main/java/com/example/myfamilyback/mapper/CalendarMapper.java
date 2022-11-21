package com.example.myfamilyback.mapper;

import com.example.myfamilyback.dto.CalendarDTO;
import com.example.myfamilyback.entities.Calendar;
import com.example.myfamilyback.entities.Member;
import com.example.myfamilyback.filter.calendar.InsertCalendar;
import com.example.myfamilyback.filter.calendar.UpdateCalendar;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CalendarMapper {

    @Transactional
    public CalendarDTO toDto(Calendar calendar){
        if(calendar==null){
            return null;
        }
        List<Long> membersId = null;
        if(calendar.getMemberList() != null){
            membersId = calendar
                    .getMemberList()
                    .stream()
                    .map(Member::getId)
                    .toList();
        }
        return CalendarDTO.builder()
                .calendarId(calendar.getId())
                .calendarName(calendar.getCalendarName())
                .calendarPassword(calendar.getCalendarPassword())
                .creationDate(calendar.getCreationDate())
                .memberList(membersId)
                .build();
    }


    public Calendar toEntity(InsertCalendar toInsert){
        if(toInsert == null){
            return null;
        }
        else{
            Calendar calendar = new Calendar();

            calendar.setCalendarName(toInsert.getCalendarName());
            calendar.setCalendarPassword(toInsert.getCalendarPassword());
            calendar.setCreationDate(toInsert.getCreationDate());

            return calendar;
        }
    }

    public Calendar toEntityU(UpdateCalendar toUpdate){
        if(toUpdate == null){
            return null;
        }
        Calendar calendar = new Calendar();

        calendar.setCalendarName(toUpdate.getCalendarName());
        calendar.setCalendarPassword(toUpdate.getCalendarPassword());
        calendar.setCreationDate(toUpdate.getCreationDate());

        return calendar;
    }
}
