package com.prestamo.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.prestamo.model.Usuario;

public interface UsuarioRepository extends Repository<Usuario,Integer>{
	void save(Usuario usuario);
	List<Usuario> findAll();
	Usuario findByUsername(String username);
	Usuario findByPassword(String password);
	//Usuario findByAdmin(String admin);
}
