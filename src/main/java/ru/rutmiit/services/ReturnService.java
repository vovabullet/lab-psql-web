package ru.rutmiit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.repositories.ProductRepository;
import ru.rutmiit.repositories.ReturnRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReturnService {
    private final ReturnRepository returnRepository;

    @Autowired
    public ReturnService(ReturnRepository returnRepository) {
        this.returnRepository = returnRepository;
    }

    public List<String> findSuppliersWithReturnsInPeriod(LocalDate startDate, LocalDate endDate) {
        return returnRepository.findDistinctSuppliersByReturnDateBetween(startDate, endDate);
    }
}