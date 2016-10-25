package com.petcenter.dto;

public class EstadoDTO {

	private Integer idEstado;
	private String codigoEstado;
	private String nombreEstado;
	private String descripcionEstado;
	
	public EstadoDTO(){}
	
	public EstadoDTO(Integer idEstado,String codigoEstado,String nombreEstado,String descripcionEstado){
		this.idEstado = idEstado;
		this.codigoEstado = codigoEstado;
		this.nombreEstado = nombreEstado;
		this.descripcionEstado = descripcionEstado;
	}
	public Integer getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
	public String getCodigoEstado() {
		return codigoEstado;
	}
	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
	public String getNombreEstado() {
		return nombreEstado;
	}
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}
	
}
