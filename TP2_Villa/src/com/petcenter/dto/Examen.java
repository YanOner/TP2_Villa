package com.petcenter.dto;

public class Examen {

	private int idEXAM;
	private String descripcion;
	public int getIdEXAM() {
		return idEXAM;
	}
	public void setIdEXAM(int idEXAM) {
		this.idEXAM = idEXAM;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Examen [idEXAM=" + idEXAM + ", descripcion=" + descripcion + "]";
	}
}
