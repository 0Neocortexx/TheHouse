package com.thehouse.repository;

import com.thehouse.model.entities.ItemMeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemMetaRepository extends JpaRepository<ItemMeta, Long> {

}