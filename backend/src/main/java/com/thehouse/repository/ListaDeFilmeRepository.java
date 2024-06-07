package com.thehouse.repository;

import com.thehouse.model.entities.ListaDeFilmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaDeFilmeRepository extends JpaRepository<ListaDeFilmes, Long> {
}
