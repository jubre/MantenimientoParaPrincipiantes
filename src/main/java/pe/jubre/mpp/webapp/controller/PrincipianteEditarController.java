package pe.jubre.mpp.webapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.jubre.mpp.model.Principiante;
import pe.jubre.mpp.service.PrincipianteService;

@Controller
@RequestMapping("/principianteEditar")
@SessionAttributes("principiante")
public class PrincipianteEditarController {
	@Autowired
	private PrincipianteService principianteService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.setRequiredFields(new String[] { "nombre" });
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ModelAttribute("principiante")
	Principiante setupForm(@RequestParam("principianteId") Long id) {
		return principianteService.obtenerPrincipiantePorId(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("principiante") Principiante principiante, BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "principianteEditar";
		}
		principianteService.actualizarPrincipiante(principiante);
		status.setComplete();
		return "redirect:/app/principianteDetalle?principianteId=" + principiante.getPrincipianteId();
	}
}
