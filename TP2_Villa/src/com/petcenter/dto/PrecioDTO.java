package com.petcenter.dto;

import java.util.Date;

public class PrecioDTO {

	private Integer idPrecio;
	private String moneda;
	private Date fechaInicial;
	private Date fechaFinal;
	private Double precio;
	private Double descuento;
	
	public PrecioDTO(){}
	
	public PrecioDTO(Integer idPrecio,String moneda,Date fechaInicial,Date fechaFinal, Double precio,Double descuento){
		super();
		this.idPrecio =  idPrecio;
		this.moneda =  moneda;
		this.fechaInicial =  fechaInicial;
		this.fechaFinal =  fechaFinal;
		this.precio = precio;
		this.descuento =  descuento;
	}
	
	public Integer getIdPrecio() {
		return idPrecio;
	}
	public void setIdPrecio(Integer idPrecio) {
		this.idPrecio = idPrecio;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}	
}
