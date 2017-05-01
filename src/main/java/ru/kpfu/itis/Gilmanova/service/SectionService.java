package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.Gilmanova.entity.Patient;
import ru.kpfu.itis.Gilmanova.entity.Section;
import ru.kpfu.itis.Gilmanova.repository.PatientRepository;
import ru.kpfu.itis.Gilmanova.repository.SectionRepository;

import java.util.List;

/**
 * Created by Adel on 30.04.2017.
 */
@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    public List<Section> findAll() {
        return sectionRepository.findAll();
    }
}
