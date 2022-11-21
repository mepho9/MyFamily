package com.example.myfamilyback.service.impl;

import com.example.myfamilyback.dto.CalendarDTO;
import com.example.myfamilyback.entities.Calendar;
import com.example.myfamilyback.filter.calendar.InsertCalendar;
import com.example.myfamilyback.filter.calendar.UpdateCalendar;
import com.example.myfamilyback.mapper.CalendarMapper;
import com.example.myfamilyback.repository.CalendarRepository;
import com.example.myfamilyback.service.CalendarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {

    private final CalendarMapper calendarMapper;
    private final CalendarRepository calendarRepository;

    public CalendarServiceImpl(CalendarMapper calendarMapper, CalendarRepository calendarRepository) {
        this.calendarMapper = calendarMapper;
        this.calendarRepository = calendarRepository;
    }

    @Override
    public CalendarDTO create(InsertCalendar toInsert) {

        if(toInsert == null){
            throw new IllegalArgumentException("Inserted Calendar cannot be null");
        }

        Calendar calendar = calendarMapper.toEntity(toInsert);

        calendar = calendarRepository.save(calendar);

        return calendarMapper.toDto(calendar);
    }

    @Override
    public CalendarDTO update(Long id, UpdateCalendar toUpdate) {

        if(toUpdate == null || id == null){
            throw new IllegalArgumentException("Calendar or id doesn't exist");
        }
        if(!calendarRepository.existsById(id)){
            throw new RuntimeException();
        }

        Calendar calendar = calendarMapper.toEntityU(toUpdate);
        calendar.setId(id);

        return calendarMapper.toDto(calendarRepository.save(calendar));
    }

    @Override
    public CalendarDTO getOne(Long id) {
        return calendarMapper
                .toDto(this.calendarRepository
                        .findById(id)
                        .orElseThrow(RuntimeException::new));
    }

    @Override
    public List<CalendarDTO> getAll() {
        return this.calendarRepository.findAll()
                .stream()
                .map(calendarMapper::toDto)
                .toList();
    }

    @Override
    public CalendarDTO delete(Long id) {

        Calendar calendar =
                calendarRepository
                        .findById(id)
                        .orElseThrow(RuntimeException::new);
        this.calendarRepository.delete(calendar);
        calendar.setId(null);

        return calendarMapper.toDto(calendar);
    }
}
