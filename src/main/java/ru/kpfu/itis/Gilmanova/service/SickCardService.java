package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.Gilmanova.entity.SickCard;
import ru.kpfu.itis.Gilmanova.repository.SickCardRepository;

import java.util.List;

/**
 * Created by Adel on 01.05.2017.
 */
@Service
public class SickCardService {
    @Autowired
    private SickCardRepository sickCardRepository;

    public List<SickCard> getCardsByUserId(Long userId) {
        return sickCardRepository.getCardsByUserId(userId);
    }
}
