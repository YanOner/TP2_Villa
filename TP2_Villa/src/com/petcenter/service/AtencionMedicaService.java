package com.petcenter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcenter.dao.spec.AtencionMedicaMapper;
import com.petcenter.dto.AtencionMedica;
import com.petcenter.dto.Diagnostico;
import com.petcenter.dto.Examen;

/**
 * 
 * @author Gianmarco Malex Trillo
 *
 */
@Service
public class AtencionMedicaService {

	@Autowired
	AtencionMedicaMapper atencionMedicaMapper;
	
	public List<Examen> listaExamenes(){
		return atencionMedicaMapper.listaExamenes();
	}
	
	public List<Diagnostico> listaDiagnostico(){
		return atencionMedicaMapper.listaDiagnostico();
	}

	public List<AtencionMedica> listaAM(String txtHC, String txtAM, String txtNUMDOC) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("idHC", txtHC);
		mapa.put("idAM", txtAM);
		mapa.put("nroDocumento", txtNUMDOC);
		return atencionMedicaMapper.listaAM(mapa);
	}
	
}
