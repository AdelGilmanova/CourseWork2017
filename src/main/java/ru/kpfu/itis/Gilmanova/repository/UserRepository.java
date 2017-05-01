package ru.kpfu.itis.Gilmanova.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.entity.UserInfo;

/**
 * Created by Adel on 30.04.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<UserInfo, Long> {
    @Query("select u from UserInfo u where u.login =:login")
    UserInfo getUser(@Param("login") String login);
}
