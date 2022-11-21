package com.example.myfamilyback.service;

import com.example.myfamilyback.dto.CalendarDTO;
import com.example.myfamilyback.filter.calendar.InsertCalendar;
import com.example.myfamilyback.filter.calendar.UpdateCalendar;

public interface CalendarService extends CrudService<CalendarDTO, Long, InsertCalendar, UpdateCalendar> {
    CalendarDTO update(Long id, UpdateCalendar toUpdate);
}
