package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.Gilmanova.entity.Address;
import ru.kpfu.itis.Gilmanova.entity.SickCard;
import ru.kpfu.itis.Gilmanova.repository.AddressRepository;
import ru.kpfu.itis.Gilmanova.repository.SickCardRepository;

import java.util.List;

/**
 * Created by Adel on 01.05.2017.
 */
@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address getAddressByUserId(Long userId) {
        return addressRepository.getAddressByUserId(userId);
    }
}
