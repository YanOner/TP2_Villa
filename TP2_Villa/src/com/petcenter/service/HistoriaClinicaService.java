package com.petcenter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcenter.dao.spec.HistoriaClinicaMapper;
import com.petcenter.dto.DatosClienteMascota;
import com.petcenter.dto.HistoriaClinica;

/**
 * 
 * @author Gianmarco Malex Trillo
 *
 */
@Service
public class HistoriaClinicaService {

	@Autowired
	HistoriaClinicaMapper historiaClinicaMapper;
	
	public List<DatosClienteMascota> listaClienteMascota(String tipoDoc, String numDoc){
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("tipoDoc", tipoDoc);
		mapa.put("numDoc", numDoc);
		return historiaClinicaMapper.listaClienteMascota(mapa);
	}
	
	public int registrarHC(HistoriaClinica historiaClinica){
		return historiaClinicaMapper.registrarHC(historiaClinica);
	}

	public List<HistoriaClinica> listaHC(String idHC, String numDOC){
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("idHC", idHC);
		mapa.put("numDOC", numDOC);
		return historiaClinicaMapper.listaHC(mapa);
	}
	
	public DatosClienteMascota verHC(int idHC){
		return historiaClinicaMapper.verHC(idHC);
	}
	
	public int eliminarHC(int idHC){
		return historiaClinicaMapper.eliminarHC(idHC);
	}
}
