package com.gestionUser.Services;

import java.util.List;
import java.util.Optional;

import com.gestionUser.models.Domicilio;



public interface IService <T,S>{
	List<T> litar();
	Optional<T> getById(Long id);
	void guardar (S t);
	void eliminar(Long id);
	Optional<T> getByNombre(String nombre);
	void guardarDomicilio(Domicilio domicilio);
	
	

}

