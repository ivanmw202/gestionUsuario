package com.gestionUser.Controllers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestionUser.Services.IService;
import com.gestionUser.dto.DomicilioDTO;
import com.gestionUser.models.Domicilio;
import com.gestionUser.models.Usuario;

import jakarta.persistence.EntityNotFoundException;


@RestController
@RequestMapping("api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioControllers {
	@Autowired
	IService<Usuario,Usuario> userService;
	@Autowired
	IService<Domicilio,DomicilioDTO> domicilioService;
	@PostMapping
	public Map<String, String> guardar(@RequestBody Usuario c){
		userService.guardar(c);
		Map<String, String> usuarios = new HashMap<>();
		usuarios.put("msg","Usuario guardado correctamente");
		return usuarios;
	}
	

    @PostMapping("/{usuarioId}/domicilio")
    public ResponseEntity<Object> agregarDomicilio(@PathVariable Long usuarioId, @RequestBody Domicilio domicilio) {
        // Lógica para asociar el domicilio al usuario y guardar en la base de datos
        Optional<Usuario> usuarioOptional = userService.getById(usuarioId);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            domicilio.setUsuario(usuario);
            domicilioService.guardarDomicilio(domicilio);
            return new ResponseEntity<>("Domicilio agregado correctamente", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }
	@GetMapping
	public List<Usuario> listar(){
		List<Usuario> usuarios = userService.litar();
		usuarios.sort(Comparator.comparing(Usuario::getNombre));
		return userService.litar();
	}
	@GetMapping("/obtener")
	public ResponseEntity<Object> obtenerPorIdONombre(@RequestParam(name = "id", required = false) Long id,
	                                                  @RequestParam(name = "nombre", required = false) String nombre) {

	    if (id != null) {
	        Optional<Usuario> usuarioPorId = userService.getById(id);
	        if (usuarioPorId.isPresent()) {
	            return new ResponseEntity<>(usuarioPorId.get(), HttpStatus.OK);
	        }
	    } else if (nombre != null) {
	        Optional<Usuario> usuarioPorNombre = userService.getByNombre(nombre);
	        if (usuarioPorNombre.isPresent()) {
	            return new ResponseEntity<>(usuarioPorNombre.get(), HttpStatus.OK);
	        }
	    }

	    String respuesta = "Usuario no encontrado con ID: " + id + " y nombre: " + nombre;
	    return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "id")Long id){
		Optional<Usuario> usuarios = userService.getById(id);
		if (usuarios.isPresent()) {
			userService.eliminar(id);
			}else {
				Map<String, String> respuesta = new HashMap<>();
				respuesta.put("msg","El usuario no existe en la BD");
				return respuesta;

			}

		userService.eliminar(id);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("msg", "Usuario eliminado correctamente");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
    public Map<String, String> actualizar(@RequestBody Usuario usuario, @PathVariable(name = "id") Long id) {
        Optional<Usuario> usuarioExistente = userService.getById(id);
        if (usuarioExistente.isPresent()) {
            usuario.setId(id);
            userService.guardar(usuario);
            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("msg", "Usuario actualizado correctamente");
            return respuesta;
        } else {
        	//no se encuentra la entidad que se esta buscando.
            throw new EntityNotFoundException("El Usuario no existe en la bd");
        }
    }
	
}
