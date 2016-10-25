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

import com.petcenter.dto.DatosClienteMascota;
import com.petcenter.dto.HistoriaClinica;
import com.petcenter.service.CommonService;
import com.petcenter.service.HistoriaClinicaService;

/**
 * 
 * @author Gianmarco Malex Trillo
 *
 */
@Controller
@RequestMapping("/HC")
public class GestionarHistoriaClinica {

	private static final Log log = LogFactory.getLog(GestionarHistoriaClinica.class);
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private HistoriaClinicaService historiaClinicaService;
	
	@RequestMapping("/listar")
	public ModelAndView listar(){
		ModelAndView mav = new ModelAndView("medica/HClistar");
		return mav;
	}
	
	@RequestMapping("/cargarRegistrar")
	public ModelAndView cargarRegistrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/HCregistrar");
//		mav.addObject("listaTipoDoc", commonService.listaTipoDoc());
		try {
			request.getSession().setAttribute("listaTipoDoc", commonService.listaTipoDoc());
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("medica/HClistar");
		}
		return mav;
	}
	
	@RequestMapping("/cargarBuscar")
	public ModelAndView cargarBuscar(){
		ModelAndView mav = new ModelAndView("medica/HCbuscar");
		return mav;
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public ModelAndView registrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/HClistar");
		try {
			String idCliente = request.getParameter("hdnIDCLIENTE");
			String idMascota = request.getParameter("txtMASCOTA");
			String edad = request.getParameter("txtEDAD");
			String observacion = request.getParameter("txtOBS");
				
			HistoriaClinica hc = new HistoriaClinica();
			hc.setIdCliente(Integer.parseInt(idCliente));
			hc.setIdMascota(Integer.parseInt(idMascota));
			if(!edad.equals(""))
				hc.setEdad(Integer.parseInt(edad));
			
			hc.setObservaciones(observacion);
				
			historiaClinicaService.registrarHC(hc);
			
			List<HistoriaClinica> listaHC = historiaClinicaService.listaHC(String.valueOf(hc.getIdHC()),"");
			
			request.getSession().setAttribute("listaHC", listaHC);
			request.getSession().setAttribute("txtHC", hc.getIdHC());
			request.getSession().setAttribute("txtNUMDOC", null);
			
			mav.addObject("mensaje", "Se registró la Historia Clínica con código: "+hc.getIdHC());
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("medica/HCregistrar");
		}
		return mav;
	}
	
	@RequestMapping("/buscar")
	public ModelAndView buscar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/HClistar");
		try {
			String txtHC = request.getParameter("txtHC");
			String txtNUMDOC = request.getParameter("txtNUMDOC");

			List<HistoriaClinica> listaHC = historiaClinicaService.listaHC(txtHC, txtNUMDOC);
			
			request.getSession().setAttribute("listaHC", listaHC);
			request.getSession().setAttribute("txtHC", txtHC);
			request.getSession().setAttribute("txtNUMDOC", txtNUMDOC);
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
		}
		return mav;
	}
	
	@RequestMapping("/detalle")
	public ModelAndView detalle(@RequestParam int idHC){
		ModelAndView mav = new ModelAndView("medica/HCdetalle");
		try {
			DatosClienteMascota hc = historiaClinicaService.verHC(idHC);
			mav.addObject("hc", hc);
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("medica/HClistar");
		}
		return mav;
	}
	
	@RequestMapping("/limpiar")
	public ModelAndView limpiar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/HClistar");
		request.getSession().setAttribute("listaHC", null);
		request.getSession().setAttribute("txtHC", null);
		request.getSession().setAttribute("txtNUMDOC", null);
		return mav;
	}
	
	@RequestMapping("/eliminar")
	public ModelAndView eliminar(HttpServletRequest request, @RequestParam int idHC){
		ModelAndView mav = new ModelAndView("medica/HClistar");
		try {
			int resultado = historiaClinicaService.eliminarHC(idHC);
			if(resultado>0){
				mav.addObject("mensaje", "Se eliminó correctamente la Historia Clínica con codigo: "+idHC);

				String txtHC = (String) request.getSession().getAttribute("txtHC");
				String txtNUMDOC = (String) request.getSession().getAttribute("txtNUMDOC");
				
				List<HistoriaClinica> listaHC = historiaClinicaService.listaHC(txtHC, txtNUMDOC);
				
				request.getSession().setAttribute("listaHC", listaHC);
				
			}else{
				mav.addObject("mensaje", "Ocurrió un error en el Sistema.");
			}
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
