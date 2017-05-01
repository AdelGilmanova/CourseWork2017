package ru.kpfu.itis.Gilmanova.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.entity.Address;
import ru.kpfu.itis.Gilmanova.entity.Patient;
import ru.kpfu.itis.Gilmanova.entity.UserInfo;

/**
 * Created by Adel on 30.04.2017.
 */
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
    @Query("select p from Patient p where p.userInfo.id =:userId")
    Patient getPatientByUserId(@Param("userId") Long userId);

    @Query("select p.id from Patient p where p.card_number =:number")
    Long getUserIdByNumberId(@Param("number") Integer number);
}
