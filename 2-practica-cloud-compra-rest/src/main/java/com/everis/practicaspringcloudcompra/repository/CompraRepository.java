package com.everis.practicaspringcloudcompra.repository;

import org.springframework.stereotype.Repository;

import com.everis.practicaspringcloudcompra.model.Compra;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

}
