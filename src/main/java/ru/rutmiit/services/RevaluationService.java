package ru.rutmiit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.models.entities.Revaluation;
import ru.rutmiit.repositories.RevaluationRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RevaluationService {
    private final RevaluationRepository revaluationRepository;

    @Autowired
    public RevaluationService(RevaluationRepository revaluationRepository) {
        this.revaluationRepository = revaluationRepository;
    }

    public List<Revaluation> findAll() {
        return revaluationRepository.findAll();
    }

    public Revaluation save(Revaluation revaluation) {
        return revaluationRepository.save(revaluation);
    }
}
