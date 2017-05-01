package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.Gilmanova.repository.ServiceRepository;

import java.util.List;

/**
 * Created by Adel on 01.05.2017.
 */
@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public List<ru.kpfu.itis.Gilmanova.entity.Service> getServiceBySectionId(Long sectionId) {
        return serviceRepository.getServiceBySectionId(sectionId);
    }
}
