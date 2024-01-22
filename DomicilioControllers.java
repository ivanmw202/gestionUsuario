package com.gestionUser.Controllers;


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
@RestController
@RequestMapping ("/api/domicilio")
@CrossOrigin(origins = "*")
public class DomicilioControllers {
	@Autowired
	IService<Domicilio,DomicilioDTO> domicilioService;
	
	@PostMapping
	public Map<String, String> guardar(@RequestBody DomicilioDTO c){
		domicilioService.guardar(c);
		Map<String, String> domicilio = new HashMap<>();
		domicilio.put("msg","Domicilio guardado correctamente" );
		return domicilio;
	}
	@GetMapping
	public List<Domicilio> listar(){
		return domicilioService.litar();
	}
	
	@GetMapping("obtener/{id}")
	public ResponseEntity<Object> obtenerPorId(@PathVariable(name = "id") Long id,
	        @RequestParam(name = "colonia", required = false) String colonia) {

	    Optional<Domicilio> domicilio = domicilioService.getById(id);
	    Optional<Domicilio> domicilioPorColonia = domicilioService.getByNombre(colonia);

	    if (domicilioPorColonia.isPresent()) {
	        return new ResponseEntity<>(domicilioPorColonia.get(), HttpStatus.OK);
	    } else if (domicilio.isPresent()) {
	        return new ResponseEntity<>(domicilio.get(), HttpStatus.OK);
	    } else {
	        String respuesta = "Domicilio no encontrado con ID: " + id + " y colonia: " + colonia;
	        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
	    }
	}

	
	@DeleteMapping("/eliminar")
	public ResponseEntity<Object> eliminar(@RequestParam(name = "id") Long id) {
        Optional<Domicilio> domicilio = domicilioService.getById(id);

        if (domicilio.isPresent()) {
            domicilioService.eliminar(id);
            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("msg", "Domicilio eliminado correctamente");
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } else {
            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("msg", "El domicilio no existe en la BD");
            return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
        }
    }
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Object> actualizar(@RequestBody DomicilioDTO c, @PathVariable(name = "id") Long id) {
        Optional<Domicilio> domicilio = domicilioService.getById(id);

        if (domicilio.isPresent()) {
            c.setId(id);
            domicilioService.guardar(c);
            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("msg", "Domicilio actualizado correctamente");
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } else {
            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("msg", "El Domicilio no existe en la bd");
            return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
        }
    }
}
