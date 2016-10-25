package com.petcenter.dto;

import java.util.Arrays;

public class DatosClienteMascota {

	private int idHC;
	private int idCliente; 
	private String descDoc;
	private String numDoc;
	private String datosCliente;
	private int idMascota;
	private String datosMascota; 
	private byte[] fotoMascota;
	private String fotoString;
    private String descripcionRaza;
    private String descripcionEspecie;
    private String descripcionGenMascota;
    private int edad;
    private String observaciones;
    
	public int getIdHC() {
		return idHC;
	}
	public void setIdHC(int idHC) {
		this.idHC = idHC;
	}
	public String getDescDoc() {
		return descDoc;
	}
	public void setDescDoc(String descDoc) {
		this.descDoc = descDoc;
	}
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getDatosCliente() {
		return datosCliente;
	}
	public void setDatosCliente(String datosCliente) {
		this.datosCliente = datosCliente;
	}
	public int getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}
	public String getDatosMascota() {
		return datosMascota;
	}
	public void setDatosMascota(String datosMascota) {
		this.datosMascota = datosMascota;
	}
	public byte[] getFotoMascota() {
		return fotoMascota;
	}
	public void setFotoMascota(byte[] fotoMascota) {
		this.fotoMascota = fotoMascota;
	}
	public String getDescripcionRaza() {
		return descripcionRaza;
	}
	public void setDescripcionRaza(String descripcionRaza) {
		this.descripcionRaza = descripcionRaza;
	}
	public String getDescripcionEspecie() {
		return descripcionEspecie;
	}
	public void setDescripcionEspecie(String descripcionEspecie) {
		this.descripcionEspecie = descripcionEspecie;
	}
	public String getDescripcionGenMascota() {
		return descripcionGenMascota;
	}
	public void setDescripcionGenMascota(String descripcionGenMascota) {
		this.descripcionGenMascota = descripcionGenMascota;
	}
	public String getFotoString() {		
//		String fotoString = "";
//		try {
//			byte[] imageBytes = fotoMascota.getBytes(1, (int) fotoMascota.length());
//			fotoString = new String(imageBytes);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return fotoString;
	}
	public void setFotoString(String fotoString) {
		this.fotoString = fotoString;
	}
	
	@Override
	public String toString() {
		return "DatosClienteMascota [idHC=" + idHC + ", idCliente=" + idCliente + ", descDoc=" + descDoc + ", numDoc="
				+ numDoc + ", datosCliente=" + datosCliente + ", idMascota=" + idMascota + ", datosMascota="
				+ datosMascota + ", fotoMascota=" + Arrays.toString(fotoMascota) + ", fotoString=" + fotoString
				+ ", descripcionRaza=" + descripcionRaza + ", descripcionEspecie=" + descripcionEspecie
				+ ", descripcionGenMascota=" + descripcionGenMascota + ", edad=" + edad + ", observaciones="
				+ observaciones + "]";
	}
	
}
