package ru.rutmiit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.models.entities.Revaluation;
import ru.rutmiit.services.RevaluationService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/revaluations")
public class RevaluationController {
    private final RevaluationService revaluationService;

    @Autowired
    public RevaluationController(RevaluationService revaluationService) {
        this.revaluationService = revaluationService;
    }

    @GetMapping
    public List<Revaluation> getAllRevaluations() {
        return revaluationService.findAll();
    }

    @PostMapping
    public Revaluation saveRevaluation(@RequestBody Revaluation revaluation) {
        return revaluationService.save(revaluation);
    }
}
