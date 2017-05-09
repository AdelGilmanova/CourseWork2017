package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.Gilmanova.entity.Patient;
import ru.kpfu.itis.Gilmanova.repository.PatientRepository;

/**
 * Created by Adel on 30.04.2017.
 */
@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient getPatientByUserId(Long id) {
        return patientRepository.getPatientByUserId(id);
    }


    public Long getUserIdByNumberId(Integer number) {
        return patientRepository.getUserIdByNumberId(number);
    }


    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public String checkСardNumber(Integer cardNumber) {
        Patient patient = patientRepository.getUserIdByCardNumberId(cardNumber);
        if (patient != null){
            return "ok";  //если существует возвращает ok
        }
        else {
            return "no";
        }
    }
}
