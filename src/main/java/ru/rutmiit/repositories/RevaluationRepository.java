package ru.rutmiit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rutmiit.models.entities.Revaluation;

@Repository
public interface RevaluationRepository extends JpaRepository<Revaluation, Long> {
    // Методы для специфических запросов
}
