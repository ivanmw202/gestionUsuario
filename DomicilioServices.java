package com.gestionUser.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestionUser.Dao.IDomicilioDao;
import com.gestionUser.Dao.IUsuarioDao;
import com.gestionUser.dto.DomicilioDTO;
import com.gestionUser.models.Domicilio;



@Service
public class DomicilioServices implements IService<Domicilio,DomicilioDTO>{
	
	@Autowired
	private IDomicilioDao domiciliaDao;
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	public List<Domicilio> litar() {
		// TODO Auto-generated method stub
		List<Domicilio>domicilio = new ArrayList<>();;
		domicilio = (List<Domicilio>)domiciliaDao.findAll();
		return domicilio;
	}

	@Override
	public Optional<Domicilio> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Domicilio> domicilio = domiciliaDao.findById(id);
		return domicilio;
	}

	@Override
	public void guardar(DomicilioDTO t) {
		// TODO Auto-generated method stub
		this.domiciliaDao.save(this.convertirDTODomicilio(t));
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.domiciliaDao.deleteById(id);
	}

	@Override
	public Optional<Domicilio> getByNombre(String nombre) {
	    return domiciliaDao.findByColonia(nombre);
	}
	
	public void guardarDomicilio(Domicilio domicilio) {
		domiciliaDao.save(domicilio);
    }
	//metodo para convertir dto en un metodo original
		public Domicilio convertirDTODomicilio(DomicilioDTO Domiciliodto) {
			Domicilio v = new Domicilio();
			v.setId(Domiciliodto.getId());
			v.setCalle(Domiciliodto.getCalle());
			v.setNumeroInterior(Domiciliodto.getNumeroInterior());
			v.setNumeroxteriro(Domiciliodto.getNumeroExterior());
			v.setColonia(Domiciliodto.getColonia());
			v.setCp(Domiciliodto.getCp());
			v.setMunicipio(Domiciliodto.getMunicipio());
			v.setEstado(Domiciliodto.getEstado());
			
			v.setUsuario(usuarioDao.findById(Domiciliodto.getUsuarioId()).get());
			
			
			return v;

	
		}


}
