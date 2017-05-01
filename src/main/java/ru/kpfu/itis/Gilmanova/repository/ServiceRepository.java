package ru.kpfu.itis.Gilmanova.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.entity.Service;
import ru.kpfu.itis.Gilmanova.entity.SickCard;

import java.util.List;

/**
 * Created by Adel on 01.05.2017.
 */
@Repository
public interface ServiceRepository extends CrudRepository<Service, Long> {
    @Query("select s from Service s where s.section.id =:sectionId")
    List<Service> getServiceBySectionId(@Param("sectionId") Long sectionId);
}
