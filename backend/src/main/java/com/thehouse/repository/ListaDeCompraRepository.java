package com.thehouse.repository;

import com.thehouse.model.entities.ListaDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaDeCompraRepository extends JpaRepository<ListaDeCompra, Long> {
}
