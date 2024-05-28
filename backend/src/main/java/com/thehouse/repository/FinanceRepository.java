package com.thehouse.repository;

import com.thehouse.model.entities.Financas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinanceRepository extends JpaRepository<Financas, Long> {

    /*
     * findAll: Indica que o método retornará todos os registros.
     * ByOrderBy: Especifica que a consulta deve ordenar os resultados.
     * Valor: O campo pelo qual a ordenação será feita.
     * Desc: Indica que a ordenação será em ordem decrescente .
     */
    List<Financas> findAllByOrderByIdAsc();
}