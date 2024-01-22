package com.gestionUser.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionUser.Dao.IUsuarioDao;
import com.gestionUser.models.Domicilio;
import com.gestionUser.models.Usuario;

@Service
public class UsuarioServices implements IService<Usuario,Usuario> {
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	public List<Usuario> litar() {
		// TODO Auto-generated method stub
		List<Usuario>usuarios = new ArrayList<>();;
		usuarios = (List<Usuario>)usuarioDao.findAll();
		return usuarios;
	}

	@Override
	public Optional<Usuario> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Usuario> usuarios = usuarioDao.findById(id);
		return usuarios;
	}

	@Override
	public void guardar(Usuario t) {
		// TODO Auto-generated method stub
		this.usuarioDao.save(t);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.usuarioDao.deleteById(id);
	}

	@Override
	public Optional<Usuario> getByNombre(String nombre) {
		// TODO Auto-generated method stub
		  return usuarioDao.findByNombre(nombre);
	}

	@Override
	public void guardarDomicilio(Domicilio domicilio) {
		// TODO Auto-generated method stub
		
	}
	
	

}
