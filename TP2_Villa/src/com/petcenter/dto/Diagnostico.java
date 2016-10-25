package com.petcenter.dto;

public class Diagnostico {

	private int idDIAG;
	private String descripcion;
	public int getIdDIAG() {
		return idDIAG;
	}
	public void setIdDIAG(int idDIAG) {
		this.idDIAG = idDIAG;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Diagnostico [idDIAG=" + idDIAG + ", descripcion=" + descripcion + "]";
	}
}
