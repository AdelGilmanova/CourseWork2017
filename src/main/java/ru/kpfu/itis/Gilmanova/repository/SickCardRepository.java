package ru.kpfu.itis.Gilmanova.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.entity.SickCard;
import ru.kpfu.itis.Gilmanova.entity.UserInfo;

import java.util.List;

/**
 * Created by Adel on 01.05.2017.
 */
@Repository
public interface SickCardRepository extends CrudRepository<SickCard, Long> {
    @Query("select s from SickCard s where s.patient.userInfo.id =:userId order by s.start desc")
    List<SickCard> getCardsByUserId(@Param("userId") Long userId);

    @Query("select s from SickCard s where s.patient.id =:patientId and s.doctor.id =:doctorId order by s.start desc")
    List<SickCard> getPatientCardsByDoctorId(@Param("patientId") Long patientId, @Param("doctorId") Long doctorId);

    @Query("select s from SickCard s where s.id =:cardId")
    SickCard getCardByCardId(@Param("cardId")Long cardId);
}
