package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.Gilmanova.entity.Schedule;
import ru.kpfu.itis.Gilmanova.entity.Section;
import ru.kpfu.itis.Gilmanova.repository.ScheduleRepository;
import ru.kpfu.itis.Gilmanova.repository.SectionRepository;

import java.util.List;

/**
 * Created by Adel on 30.04.2017.
 */
@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public Schedule addSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long schId) {
        scheduleRepository.delete(schId);
    }
}
