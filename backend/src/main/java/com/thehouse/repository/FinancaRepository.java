package com.thehouse.repository;

import com.thehouse.model.entities.Financa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancaRepository extends JpaRepository<Financa, Long> {

    /*
     * findAll: Indica que o método retornará todos os registros.
     * ByOrderBy: Especifica que a consulta deve ordenar os resultados.
     * Valor: O campo pelo qual a ordenação será feita.
     * Desc: Indica que a ordenação será em ordem decrescente .
     */
    List<Financa> findAllByOrderByIdAsc();
}