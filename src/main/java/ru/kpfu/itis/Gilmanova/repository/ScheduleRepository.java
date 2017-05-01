package ru.kpfu.itis.Gilmanova.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.entity.Schedule;
import ru.kpfu.itis.Gilmanova.entity.Section;

import java.util.List;

/**
 * Created by Adel on 30.04.2017.
 */
@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
    @Query("select p from Schedule p order by p.day asc, p.start asc")
    List<Schedule> findAll();
}
