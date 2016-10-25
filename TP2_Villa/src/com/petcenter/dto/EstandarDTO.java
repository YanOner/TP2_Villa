package com.petcenter.dto;

public class EstandarDTO {
	
	private Integer idEstandar;
	private String codigoEstandar;
	private String nombreEstandar;
	private String descripcionEstandar;
	
	public EstandarDTO(){}
	
	public EstandarDTO(Integer idEstandar,String  codigoEstandar,String nombreEstandar,String descripcionEstandar){
		super();
		this.idEstandar = idEstandar;
		this.codigoEstandar = codigoEstandar;
		this.nombreEstandar = nombreEstandar;
		this.descripcionEstandar = descripcionEstandar;
	}
	
	public Integer getIdEstandar() {
		return idEstandar;
	}
	public void setIdEstandar(Integer idEstandar) {
		this.idEstandar = idEstandar;
	}
	public String getCodigoEstandar() {
		return codigoEstandar;
	}
	public void setCodigoEstandar(String codigoEstandar) {
		this.codigoEstandar = codigoEstandar;
	}
	public String getNombreEstandar() {
		return nombreEstandar;
	}
	public void setNombreEstandar(String nombreEstandar) {
		this.nombreEstandar = nombreEstandar;
	}
	public String getDescripcionEstandar() {
		return descripcionEstandar;
	}
	public void setDescripcionEstandar(String descripcionEstandar) {
		this.descripcionEstandar = descripcionEstandar;
	}
}
