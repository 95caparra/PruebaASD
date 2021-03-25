package com.asd.activos.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.asd.activos.entity.Activo;
import com.asd.activos.entity.Area;
import com.asd.activos.entity.EstadoActivo;
import com.asd.activos.entity.Persona;

public interface IActivoService {
	
	public List<Activo> findAll();
	
	public Page<Activo> findAll(Pageable pageable);
	
	public Activo findById(Long id);
	
	public List<Activo> findAllByTipo(String tipo);
	
	public List<Activo> findAllByFechaCompra(LocalDate fechaCompra);
	
	public List<Activo> findAllByTermino(String termino);
	
	public Activo findBySerial(String serial);
	
	public Activo save(Activo Activo);
	
	public void delete(Long id);
	
	public List<Area> findAllArea();
	
	public List<Persona> findAllPersona();
	
	public List<EstadoActivo> findAllEstadoActivo();

}
