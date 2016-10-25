package com.petcenter.dao.spec;

import java.util.List;
import java.util.Map;

import com.petcenter.dto.DatosClienteMascota;
import com.petcenter.dto.HistoriaClinica;

/**
 * 
 * @author Gianmarco Malex Trillo
 *
 */
public interface HistoriaClinicaMapper {

	List<DatosClienteMascota> listaClienteMascota(Map<String, Object> mapa);
	int registrarHC(HistoriaClinica historiaClinica); 
	List<HistoriaClinica> listaHC(Map<String, Object> mapa);
	DatosClienteMascota verHC(int idHC);
	int eliminarHC(int idHC);
}
