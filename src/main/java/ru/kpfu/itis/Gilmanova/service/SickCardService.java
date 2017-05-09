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

    public void addNote(SickCard sickCard) {
        sickCardRepository.save(sickCard);
    }

    public List<SickCard> getPatientCardsByDoctorId(Long patientId, Long doctorId) {
        return sickCardRepository.getPatientCardsByDoctorId(patientId, doctorId);
    }

    public SickCard getCardByCardId(Long cardId) {
        return sickCardRepository.getCardByCardId(cardId);
    }
}
