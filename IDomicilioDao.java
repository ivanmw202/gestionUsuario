package com.gestionUser.Dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.gestionUser.models.Domicilio;

public interface IDomicilioDao extends CrudRepository<Domicilio, Long> {
	Optional<Domicilio> findByColonia(String colonia);

}
