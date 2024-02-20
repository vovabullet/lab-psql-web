package ru.rutmiit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rutmiit.models.entities.Return;

public interface ReturnRepository extends JpaRepository<Return, Integer> {
}
