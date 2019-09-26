package com.everis.practicaspringcloudcompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.practicaspringcloudcompra.model.Inventario;

@Repository
public interface InventarioRepository  extends JpaRepository<Inventario, Integer>{

}
