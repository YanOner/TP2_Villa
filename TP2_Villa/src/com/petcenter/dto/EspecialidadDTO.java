package com.petcenter.dto;

public class EspecialidadDTO {
	
	private Integer idEspecialidad;
	private String codigoEspecialidad;
	private String nombreEspecialidad;
	private String descripcionEspecialidad;
	private Integer idEstado;
	
	public EspecialidadDTO(){}
	
	public EspecialidadDTO(Integer idEspecialidad,String codigoEspecialidad,String nombreEspecialidad,
			String descripcionEspecialidad,Integer idEstado){
		super();
		this.idEspecialidad = idEspecialidad;
		this.codigoEspecialidad = codigoEspecialidad;
		this.nombreEspecialidad = nombreEspecialidad;
		this.descripcionEspecialidad = descripcionEspecialidad;
		this.idEstado =  idEstado;
	}
	
	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	public String getCodigoEspecialidad() {
		return codigoEspecialidad;
	}
	public void setCodigoEspecialidad(String codigoEspecialidad) {
		this.codigoEspecialidad = codigoEspecialidad;
	}
	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}
	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}
	public String getDescripcionEspecialidad() {
		return descripcionEspecialidad;
	}
	public void setDescripcionEspecialidad(String descripcionEspecialidad) {
		this.descripcionEspecialidad = descripcionEspecialidad;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
	
	
}
