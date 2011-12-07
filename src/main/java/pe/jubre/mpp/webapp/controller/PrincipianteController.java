package pe.jubre.mpp.webapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.jubre.mpp.model.Principiante;
import pe.jubre.mpp.service.PrincipianteService;

@Controller
public class PrincipianteController {

	@Autowired
	private PrincipianteService principianteService;

	@RequestMapping("/principianteLista")
	public @ModelAttribute("principiantes")
	List<Principiante> principianteLista() {
		return principianteService.obtenerListaPrincipiantes();
	}

	@RequestMapping("/principianteDetalle")
	public @ModelAttribute("principiante")
	Principiante principianteDetalle(@RequestParam("principianteId") long id) throws ServletRequestBindingException {
		return principianteService.obtenerPrincipiantePorId(id);
	}
}
