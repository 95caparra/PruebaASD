package com.asd.activos.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asd.activos.dao.IActivoDAO;
import com.asd.activos.entity.Activo;
import com.asd.activos.entity.Area;
import com.asd.activos.entity.EstadoActivo;
import com.asd.activos.entity.Persona;
import com.asd.activos.services.IActivoService;

@Service
public class ActivoServiceImp implements IActivoService {
	
	@Autowired
	private IActivoDAO activoDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Activo> findAll() {
		return activoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Activo> findAll(Pageable pageable) {
		return activoDAO.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Activo findById(Long id) {
		return activoDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Activo save(Activo Activo) {
		return activoDAO.save(Activo);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		activoDAO.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Activo> findAllByTipo(String tipo) {
		return activoDAO.findAllByTipo(tipo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Activo> findAllByFechaCompra(LocalDate fechaCompra) {
		return activoDAO.findAllByFechaCompra(fechaCompra);
	}

	@Override
	@Transactional(readOnly = true)
	public Activo findBySerial(String serial) {
		return activoDAO.findBySerial(serial);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Area> findAllArea() {
		return activoDAO.findAllArea();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAllPersona() {
		return activoDAO.findAllPersona();
	}

	@Override
	@Transactional(readOnly = true)
	public List<EstadoActivo> findAllEstadoActivo() {
		return activoDAO.findAllEstadoActivo();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Activo> findAllByTermino(String termino) {
		return activoDAO.findAllByTermino(termino);
	}

}
