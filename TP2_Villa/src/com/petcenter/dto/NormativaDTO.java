package com.petcenter.dto;

public class NormativaDTO {

	private Integer idNormativa;
	private String numeroNormativa; 
	private String descripcionNormativa;
	
	public NormativaDTO(){}
	
	public NormativaDTO(Integer idNormativa,String numeroNormativa,String descripcionNormativa){
		super();
		this.idNormativa = idNormativa;
		this.numeroNormativa = numeroNormativa;
		this.descripcionNormativa = descripcionNormativa;
	}

	public Integer getIdNormativa() {
		return idNormativa;
	}

	public void setIdNormativa(Integer idNormativa) {
		this.idNormativa = idNormativa;
	}

	public String getNumeroNormativa() {
		return numeroNormativa;
	}

	public void setNumeroNormativa(String numeroNormativa) {
		this.numeroNormativa = numeroNormativa;
	}

	public String getDescripcionNormativa() {
		return descripcionNormativa;
	}

	public void setDescripcionNormativa(String descripcionNormativa) {
		this.descripcionNormativa = descripcionNormativa;
	}
	
	
}
