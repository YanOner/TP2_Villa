package com.petcenter.dto;

import java.sql.Date;

public class AtencionMedica {

	private int idAM;
	private int idHC;
	private int idDIAG;
	private int idEXAM;
	private int codMedico;
	private String desMedico;
	private int deposiciones;
	private double peso;
	private int temperatura;
	private int signovital;
	private String observacion;
	private String comentario;
	private int estadoAM;
	private Date registrado;
	private Date actualizado;
	private String datosCliente;
	private String datosMascota;
	public int getIdAM() {
		return idAM;
	}
	public void setIdAM(int idAM) {
		this.idAM = idAM;
	}
	public int getIdHC() {
		return idHC;
	}
	public void setIdHC(int idHC) {
		this.idHC = idHC;
	}
	public int getIdDIAG() {
		return idDIAG;
	}
	public void setIdDIAG(int idDIAG) {
		this.idDIAG = idDIAG;
	}
	public int getIdEXAM() {
		return idEXAM;
	}
	public void setIdEXAM(int idEXAM) {
		this.idEXAM = idEXAM;
	}
	public int getCodMedico() {
		return codMedico;
	}
	public void setCodMedico(int codMedico) {
		this.codMedico = codMedico;
	}
	public String getDesMedico() {
		return desMedico;
	}
	public void setDesMedico(String desMedico) {
		this.desMedico = desMedico;
	}
	public int getDeposiciones() {
		return deposiciones;
	}
	public void setDeposiciones(int deposiciones) {
		this.deposiciones = deposiciones;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public int getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	public int getSignovital() {
		return signovital;
	}
	public void setSignovital(int signovital) {
		this.signovital = signovital;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getEstadoAM() {
		return estadoAM;
	}
	public void setEstadoAM(int estadoAM) {
		this.estadoAM = estadoAM;
	}
	public Date getRegistrado() {
		return registrado;
	}
	public void setRegistrado(Date registrado) {
		this.registrado = registrado;
	}
	public Date getActualizado() {
		return actualizado;
	}
	public void setActualizado(Date actualizado) {
		this.actualizado = actualizado;
	}
	public String getDatosCliente() {
		return datosCliente;
	}
	public void setDatosCliente(String datosCliente) {
		this.datosCliente = datosCliente;
	}
	public String getDatosMascota() {
		return datosMascota;
	}
	public void setDatosMascota(String datosMascota) {
		this.datosMascota = datosMascota;
	}
	@Override
	public String toString() {
		return "AtencionMedica [idAM=" + idAM + ", idHC=" + idHC + ", idDIAG=" + idDIAG + ", idEXAM=" + idEXAM
				+ ", codMedico=" + codMedico + ", desMedico=" + desMedico + ", deposiciones=" + deposiciones + ", peso="
				+ peso + ", temperatura=" + temperatura + ", signovital=" + signovital + ", observacion=" + observacion
				+ ", comentario=" + comentario + ", estadoAM=" + estadoAM + ", registrado=" + registrado
				+ ", actualizado=" + actualizado + ", datosCliente=" + datosCliente + ", datosMascota=" + datosMascota
				+ "]";
	}
}
