package com.petcenter.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.petcenter.dto.AtencionMedica;
import com.petcenter.dto.DatosClienteMascota;
import com.petcenter.service.AtencionMedicaService;
import com.petcenter.service.CommonService;
import com.petcenter.service.HistoriaClinicaService;

/**
 * 
 * @author Gianmarco Malex Trillo
 *
 */
@Controller
@RequestMapping("/AM")
public class GestionarAtencionMedicaController {

	private static final Log log = LogFactory.getLog(GestionarAtencionMedicaController.class);
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private HistoriaClinicaService historiaClinicaService;

	@Autowired
	private AtencionMedicaService atencionMedicaService;
	
	@RequestMapping("/inicio")
	public ModelAndView listar(){
		ModelAndView mav = new ModelAndView("medica/AMlistar");
		return mav;
	}
	
	@RequestMapping("/cargarRegistrar")
	public ModelAndView cargarRegistrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/AMregistrar");
		try {
			request.getSession().setAttribute("listaTipoDoc", commonService.listaTipoDoc());
			request.getSession().setAttribute("listaExamenes", atencionMedicaService.listaExamenes());
			request.getSession().setAttribute("listaDiagnostico", atencionMedicaService.listaDiagnostico());
			mav.addObject("codigoMedico", 1);
			mav.addObject("datosMedico", "Doc. Vet Corbalan");
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("medica/AMlistar");
		}
		return mav;
	}
	
	@RequestMapping("/cargarBuscar")
	public ModelAndView cargarBuscar(){
		ModelAndView mav = new ModelAndView("medica/AMbuscar");
		return mav;
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public ModelAndView registrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/AMlistar");
		try {
//			String idCliente = request.getParameter("hdnIDCLIENTE");
//			String idMascota = request.getParameter("txtMASCOTA");
//			String edad = request.getParameter("txtEDAD");
//			String observacion = request.getParameter("txtOBS");
//				
//			HistoriaClinica AM = new HistoriaClinica();
//			AM.setIdCliente(Integer.parseInt(idCliente));
//			AM.setIdMascota(Integer.parseInt(idMascota));
//			if(!edad.equals(""))
//				AM.setEdad(Integer.parseInt(edad));
//			
//			AM.setObservaciones(observacion);
//				
//			historiaClinicaService.registrarAM(AM);
//			
//			List<HistoriaClinica> listaAM = historiaClinicaService.listaAM(String.valueOf(AM.getIdAM()),"");
//			
//			request.getSession().setAttribute("listaAM", listaAM);
//			request.getSession().setAttribute("txtAM", AM.getIdAM());
//			request.getSession().setAttribute("txtNUMDOC", null);
			
//			mav.addObject("mensaje", "Se registró la Atención Médica con código: "+AM.getIdAM());
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("medica/AMregistrar");
		}
		return mav;
	}
	
	@RequestMapping("/buscar")
	public ModelAndView buscar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/AMlistar");
		try {
			String txtHC = request.getParameter("txtHC");
			String txtAM = request.getParameter("txtAM");
			String txtNUMDOC = request.getParameter("txtNUMDOC");

			List<AtencionMedica> listaAM = atencionMedicaService.listaAM(txtHC, txtAM, txtNUMDOC);
			
			request.getSession().setAttribute("listaAM", listaAM);
			request.getSession().setAttribute("txtHC", txtHC);
			request.getSession().setAttribute("txtAM", txtAM);
			request.getSession().setAttribute("txtNUMDOC", txtNUMDOC);
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
		}
		return mav;
	}
	
	@RequestMapping("/detalle")
	public ModelAndView detalle(@RequestParam int idAM){
		ModelAndView mav = new ModelAndView("medica/AMdetalle");
		try {
//			DatosClienteMascota AM = historiaClinicaService.verAM(idAM);
//			mav.addObject("AM", AM);
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("medica/AMlistar");
		}
		return mav;
	}
	
	@RequestMapping("/limpiar")
	public ModelAndView limpiar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/AMlistar");
		request.getSession().setAttribute("listaAM", null);
		request.getSession().setAttribute("txtAM", null);
		request.getSession().setAttribute("txtNUMDOC", null);
		return mav;
	}
	
	@RequestMapping("/eliminar")
	public ModelAndView eliminar(HttpServletRequest request, @RequestParam int idAM){
		ModelAndView mav = new ModelAndView("medica/AMlistar");
		try {
//			int resultado = historiaClinicaService.eliminarAM(idAM);
//			if(resultado>0){
				mav.addObject("mensaje", "Se eliminó correctamente la Atención Médica con codigo: "+idAM);

//				String txtAM = (String) request.getSession().getAttribute("txtAM");
//				String txtNUMDOC = (String) request.getSession().getAttribute("txtNUMDOC");
				
//				List<HistoriaClinica> listaAM = historiaClinicaService.listaAM(txtAM, txtNUMDOC);
				
//				request.getSession().setAttribute("listaAM", listaAM);
				
//			}else{
				mav.addObject("mensaje", "Ocurrió un error en el Sistema.");
//			}
		} catch (Exception e) {
			log.error(e);
		}
		return mav;
	}
	
	@RequestMapping(value = "/validar", method = RequestMethod.GET)
	public @ResponseBody List<DatosClienteMascota> validar(@RequestParam String tipoDoc, @RequestParam String numDoc){
		List<DatosClienteMascota> datos = historiaClinicaService.listaClienteMascota(tipoDoc, numDoc);
//		for (DatosClienteMascota datosClienteMascota : datos) {
//			String fotoString = new String(Base64.encodeBase64(datosClienteMascota.getFotoMascota()));
//			datosClienteMascota.setFotoString(fotoString);
//		}
		return datos;
	}
	
}
