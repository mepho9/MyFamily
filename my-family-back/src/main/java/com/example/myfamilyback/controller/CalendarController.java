package com.example.myfamilyback.controller;


import com.example.myfamilyback.mapper.CalendarMapper;
import com.example.myfamilyback.service.CalendarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/calender")
@RestController
public class CalendarController {

    private final CalendarService calendarService;

    private final CalendarMapper calendarMapper;


    public CalendarController(CalendarService calendarService, CalendarMapper calendarMapper) {
        this.calendarService = calendarService;
        this.calendarMapper = calendarMapper;
        System.out.println("yes");
    }
}
