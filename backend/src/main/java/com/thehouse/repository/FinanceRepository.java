package com.thehouse.repository;

import com.thehouse.model.entities.Financas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceRepository extends JpaRepository<Financas, Long> {
}