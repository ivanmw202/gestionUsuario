package com.gestionUser.Dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gestionUser.models.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	Optional<Usuario> findByNombre(String nombre);

}
