package ru.rutmiit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.repositories.ReturnRepository;

import java.util.Date;
import java.util.List;

@Service
public class ReturnService {
    private final ReturnRepository returnRepository;

    @Autowired
    public ReturnService(ReturnRepository returnRepository) {
        this.returnRepository = returnRepository;
    }

    public List<String> findSuppliersWithReturnsInPeriod(Date startDate, Date endDate) {
        return returnRepository.findDistinctSuppliersByReturnDateBetween(startDate, endDate);
    }
}