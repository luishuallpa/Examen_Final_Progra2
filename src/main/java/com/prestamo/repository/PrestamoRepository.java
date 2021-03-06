package com.prestamo.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.prestamo.model.Prestamo;

public interface PrestamoRepository extends Repository<Prestamo, Integer> {
	void save(Prestamo prestamo);

	List<Prestamo> findAll();

	Prestamo findById(Integer id);
	//Buscar
	Prestamo findBydni(String dni);
}
