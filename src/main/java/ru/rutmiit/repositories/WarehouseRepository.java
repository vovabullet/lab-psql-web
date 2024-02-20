package ru.rutmiit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rutmiit.models.entities.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}

