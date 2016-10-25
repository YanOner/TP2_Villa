package com.petcenter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petcenter.dto.EspecialidadDTO;
import com.petcenter.dto.EstadoDTO;
import com.petcenter.dto.EstandarDTO;
import com.petcenter.dto.NormativaDTO;
import com.petcenter.dto.TipoExamenDTO;
import com.petcenter.service.ActualizarTipoExamenMedicoService;
import com.petcenter.util.LaboratorioConstantes;


@Controller
@RequestMapping("/actualizarTipoExamen")
public class ActualizarTipoExamenMedicoController {
	
	@Autowired
	private ActualizarTipoExamenMedicoService actualizaTipoExamenMedicoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String inicio(Model model){
		
	 
		List<EspecialidadDTO> listaEspecialidades = actualizaTipoExamenMedicoService.listarEspecialidades();
		List<EstadoDTO> listaEstados =  actualizaTipoExamenMedicoService.listarEstados();
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_ESPECIALIDADES, listaEspecialidades);
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_ESTADOS, listaEstados);

		return LaboratorioConstantes.VISTA_ACTUALIZA_TIPO_EXAMEN;
	}
	

	@RequestMapping(value="/buscar",
    produces="application/json; charset=UTF-8",
    method=RequestMethod.GET)
	public @ResponseBody Map<String,Object>  buscarTipoExamen(	@RequestParam("nombre") String nombre,
									@RequestParam("descripcion") String descripcion,
									@RequestParam("idEst") Integer idEst,
									@RequestParam("idEsp") Integer idEsp,
									Model model) {
		Map<String,Object> lista = new HashMap<String,Object>();
		List<TipoExamenDTO> listaTiposExamenesMedicos = actualizaTipoExamenMedicoService.buscarTiposExamen(nombre, descripcion, idEst, idEsp);
		lista.put(LaboratorioConstantes.NOMBRE_LISTA_BUSQUEDA_TIPOS_EXAMENES_MEDICOS, listaTiposExamenesMedicos);
		return lista;
	}
	
	@RequestMapping(value="/nuevoTipoExamen", method=RequestMethod.GET)
	public String cargarNuevoTipoExamen(Model model){
		
		List<EspecialidadDTO> listaEspecialidades = actualizaTipoExamenMedicoService.listarEspecialidades();
		List<NormativaDTO> listaNormativas = actualizaTipoExamenMedicoService.listarNormativa();
		List<EstandarDTO> listaEstandares = actualizaTipoExamenMedicoService.listaEstandares();
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_ESPECIALIDADES, listaEspecialidades);
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_BUSQUEDA_NORMATIVAS, listaNormativas);
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_BUSQUEDA_ESTANDARES,listaEstandares   );
		return LaboratorioConstantes.VISTA_NUEVO_TIPO_EXAMEN;
	}

}
