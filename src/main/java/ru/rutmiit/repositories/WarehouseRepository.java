package ru.rutmiit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rutmiit.models.entities.Warehouse;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    @Query(value = "SELECT DISTINCT w.name FROM Warehouses w JOIN Receipt_Documents rd ON w.warehouseId = rd.warehouseId WHERE rd.supplierId = :supplierId", nativeQuery = true)
    List<String> findWarehousesBySupplierId(@Param("supplierId") Long supplierId);

}

