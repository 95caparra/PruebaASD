package com.asd.activos.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "activos")
public class Activo  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(name="nombre", nullable = false, length = 200)
	private String nombre;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(name="descripcion", nullable = false, length = 200)
	private String descripcion;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(name="tipo", nullable = false, length = 200)
	private String tipo;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(name="serial", nullable = false, length = 200)
	private String serial;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(name="numero_interno", nullable = false, length = 200)
	private String NumeroInterno;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(name="peso", nullable = false, length = 200)
	private Double peso;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(name="largo", nullable = false, length = 200)
	private Long largo;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(name="ancho", nullable = false, length = 200)
	private Long ancho;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(name="valor_compra", nullable = false, length = 200)
	private Double valorCompra;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(name="fecha_compra", nullable = false, length = 200)
	private LocalDate fechaCompra;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(name="fecha_baja", nullable = false, length = 200)
	private LocalDate fechaBaja;
	
	@NotNull(message = "El Estado no puede ser nulo.")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEstado")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })	
	private EstadoActivo estado;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(name="color", nullable = false, length = 200)
	private String color;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idArea")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })	
	private Area area;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPersona")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })	
	private Persona persona;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getNumeroInterno() {
		return NumeroInterno;
	}

	public void setNumeroInterno(String numeroInterno) {
		NumeroInterno = numeroInterno;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Long getLargo() {
		return largo;
	}

	public void setLargo(Long largo) {
		this.largo = largo;
	}

	public Long getAncho() {
		return ancho;
	}

	public void setAncho(Long ancho) {
		this.ancho = ancho;
	}

	public Double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public LocalDate getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(LocalDate fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public EstadoActivo getEstado() {
		return estado;
	}

	public void setEstado(EstadoActivo estado) {
		this.estado = estado;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
}
