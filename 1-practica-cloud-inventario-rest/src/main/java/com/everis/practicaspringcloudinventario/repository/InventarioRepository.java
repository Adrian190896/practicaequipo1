package com.everis.practicaspringcloudinventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.practicaspringcloudinventario.model.Inventario;


@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long>{

	Inventario findById(long id);
}
