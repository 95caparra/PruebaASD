package com.asd.activos.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asd.activos.entity.Activo;
import com.asd.activos.entity.Area;
import com.asd.activos.entity.EstadoActivo;
import com.asd.activos.entity.Persona;


public interface IActivoDAO extends JpaRepository<Activo, Long>{

	@Query("from Area")
	public List<Area> findAllArea();
	
	@Query("from Persona")
	public List<Persona> findAllPersona();
	
	@Query("from EstadoActivo")
	public List<EstadoActivo> findAllEstadoActivo();
	
	@Query("from Activo a WHERE a.tipo =:tipo ")
    public List<Activo> findAllByTipo(String tipo);
	
	@Query("from Activo a WHERE a.nombre =:termino OR  a.descripcion =:termino ")
    public List<Activo> findAllByTermino(String termino);
	
    @Query("from Activo a WHERE a.fechaCompra = :fechaCompra")
	public List<Activo> findAllByFechaCompra(LocalDate fechaCompra);
	
	public Activo findBySerial(String serial);

}
