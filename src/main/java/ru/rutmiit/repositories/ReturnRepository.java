package ru.rutmiit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rutmiit.models.entities.Return;

import java.util.Date;
import java.util.List;

@Repository
public interface ReturnRepository extends JpaRepository<Return, Long> {

    @Query("SELECT DISTINCT s.name FROM Supplier s JOIN s.returns r WHERE r.returnDate BETWEEN :startDate AND :endDate")
    List<String> findDistinctSuppliersByReturnDateBetween(Date startDate, Date endDate);

}