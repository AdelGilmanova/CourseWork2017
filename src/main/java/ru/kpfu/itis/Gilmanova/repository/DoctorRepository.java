package ru.kpfu.itis.Gilmanova.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.entity.Doctor;
import ru.kpfu.itis.Gilmanova.entity.Patient;
import ru.kpfu.itis.Gilmanova.entity.UserInfo;

/**
 * Created by Adel on 30.04.2017.
 */
@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    @Query("select d from Doctor d where d.userInfo.id =:userId")
    Doctor getDoctorByUserId(@Param("userId") Long userId);
}
