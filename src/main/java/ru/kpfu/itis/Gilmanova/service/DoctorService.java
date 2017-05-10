package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.Gilmanova.entity.Doctor;
import ru.kpfu.itis.Gilmanova.repository.DoctorRepository;

import java.util.List;

/**
 * Created by Adel on 30.04.2017.
 */
@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor getDoctorByUserId(Long id) {
        return doctorRepository.getDoctorByUserId(id);
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long doctorId) {
        return doctorRepository.getOne(doctorId);
    }
}
