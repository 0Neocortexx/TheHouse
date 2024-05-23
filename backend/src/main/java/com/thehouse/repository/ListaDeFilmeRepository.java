package com.thehouse.repository;

import com.thehouse.model.entities.ListaDeFilmes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaDeFilmeRepository extends JpaRepository<ListaDeFilmes, Long> {
}
