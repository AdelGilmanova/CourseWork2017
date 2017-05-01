package ru.kpfu.itis.Gilmanova.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.entity.Patient;
import ru.kpfu.itis.Gilmanova.entity.Section;
import ru.kpfu.itis.Gilmanova.entity.UserInfo;

import java.util.List;

/**
 * Created by Adel on 30.04.2017.
 */
@Repository
public interface SectionRepository extends CrudRepository<Section, Long> {
    List<Section> findAll();
}
