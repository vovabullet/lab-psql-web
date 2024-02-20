package ru.rutmiit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.models.entities.Return;
import ru.rutmiit.repositories.ReturnRepository;

import java.util.List;

@Service
public class ReturnService {

    private final ReturnRepository returnRepository;

    @Autowired
    public ReturnService(ReturnRepository returnRepository) {
        this.returnRepository = returnRepository;
    }

    public List<Return> findAll() {
        return returnRepository.findAll();
    }

    public Return save(Return aReturn) {
        return returnRepository.save(aReturn);
    }

    public Return findById(Integer id) {
        return returnRepository.findById(id).orElse(null);
    }
}
