package ru.kpfu.itis.Gilmanova.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.entity.Address;
import ru.kpfu.itis.Gilmanova.entity.UserInfo;

/**
 * Created by Adel on 01.05.2017.
 */
@Repository
public interface AddressRepository extends CrudRepository<UserInfo, Long> {
    @Query("select a from Address a where a.userInfo.id =:userId")
    Address getAddressByUserId(@Param("userId") Long userId);
}
