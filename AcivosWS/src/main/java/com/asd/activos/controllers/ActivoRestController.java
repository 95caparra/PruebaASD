package com.asd.activos.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.asd.activos.entity.Activo;
import com.asd.activos.entity.Area;
import com.asd.activos.entity.EstadoActivo;
import com.asd.activos.entity.Persona;
import com.asd.activos.services.IActivoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ActivoRestController {

	@Autowired
	private IActivoService activoService;

	@GetMapping("/activos")
	public List<Activo> index() {
		return activoService.findAll();
	}

	@GetMapping("/activos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();

		Activo objeto = null;

		try {
			objeto = activoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (objeto == null) {
			response.put("mensaje",
					"El Activo con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("objeto", objeto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/activos/termino/{termino}")
	public ResponseEntity<?> showNombreODescripcion(@PathVariable String termino) {
		Map<String, Object> response = new HashMap<>();

		List<Activo> objeto = new ArrayList<Activo>();

		try {
			objeto = activoService.findAllByTermino(termino);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (objeto == null) {
			response.put("mensaje",
					"El Activo con ID: ".concat(termino.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("objeto", objeto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/activos/tipo/{tipo}")
	public ResponseEntity<?> showTipo(@PathVariable String tipo) {
		Map<String, Object> response = new HashMap<>();

		List<Activo> objeto = new ArrayList<Activo>();

		try {
			objeto = activoService.findAllByTipo(tipo);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (objeto == null) {
			response.put("mensaje",
					"El Activo con ID: ".concat(tipo.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("objeto", objeto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/activos/fechaCompra/{fecha}")
	public ResponseEntity<?> showFechaCompra(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha) {
		Map<String, Object> response = new HashMap<>();

		List<Activo> objeto = new ArrayList<Activo>();

		try {
			objeto = activoService.findAllByFechaCompra(fecha);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (objeto == null) {
			response.put("mensaje",
					"El Activo con ID: ".concat(fecha.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("objeto", objeto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/activos/serial/{serial}")
	public ResponseEntity<?> showSerial(@PathVariable String serial) {
		Map<String, Object> response = new HashMap<>();

		Activo objeto = null;

		try {
			objeto = activoService.findBySerial(serial);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (objeto == null) {
			response.put("mensaje",
					"El Activo con ID: ".concat(serial.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("objeto", objeto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/activos")
	public ResponseEntity<?> create(@Valid @RequestBody Activo objeto, BindingResult result) {

		Activo objetoNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			if (objeto.getFechaBaja().isAfter(objeto.getFechaCompra())) {
				response.put("mensaje", "la fecha de baja es superior a la fecha de compra");
				response.put("error", "la fecha de baja es superior a la fecha de compra");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				objetoNew = activoService.save(objeto);
				response.put("mensaje", "El objeto ha sido creado con éxito!");
				response.put("objeto", objetoNew);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
			}

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/activos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Activo objeto, BindingResult result, @PathVariable Long id) {

		Activo objetoActual = activoService.findById(id);

		Activo objetoUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (objetoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el  ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			objetoActual.setFechaBaja(objeto.getFechaBaja());
			objetoActual.setSerial(objeto.getSerial());

			objetoUpdated = activoService.save(objetoActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el objeto en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El objeto ha sido actualizado con éxito!");
		response.put("objeto", objetoUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/activos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();

		try {

			activoService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el objeto de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El objeto eliminado con éxito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/activos/areas")
	public List<Area> listarAreas() {
		return activoService.findAllArea();
	}

	@GetMapping("/activos/personas")
	public List<Persona> listarPersonas() {
		return activoService.findAllPersona();
	}

	@GetMapping("/activos/estados")
	public List<EstadoActivo> listarEstados() {
		return activoService.findAllEstadoActivo();
	}

}
