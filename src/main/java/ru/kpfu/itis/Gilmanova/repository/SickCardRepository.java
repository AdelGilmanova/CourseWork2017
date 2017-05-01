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
public interface SickCardRepository extends CrudRepository<UserInfo, Long> {
    @Query("select s from SickCard s where s.patient.userInfo.id =:userId")
    List<SickCard> getCardsByUserId(@Param("userId") Long userId);
}
