package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.Gilmanova.entity.UserInfo;
import ru.kpfu.itis.Gilmanova.repository.UserRepository;

/**
 * Created by Adel on 30.04.2017.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserInfo getUser(String login) {
        return userRepository.getUser(login);
    }
}
