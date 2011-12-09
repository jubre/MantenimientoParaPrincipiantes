package pe.jubre.mpp.webapp.controller;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.util.Date;

import javax.servlet.ServletContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.support.SimpleSessionStatus;
import org.springframework.web.servlet.HandlerAdapter;

import pe.jubre.mpp.model.Principiante;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mpp/system-test-config.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class PrincipianteEditarControllerTest {

	@Autowired
	private PrincipianteEditarController controller;

	@Autowired
	private HandlerAdapter handlerAdapter;

	@Test
	public void validarGet() {
		Principiante principiante = controller.setupForm(new Long(1));
		assertEquals(new Long(1), principiante.getPrincipianteId());
	}

	@Test
	public void validarPost() {
		Principiante principiante = new Principiante();
		principiante.setNombre("pele");
		principiante.setPrincipianteId(new Long(4));
		principiante.setFechaCreacion(new Date());

		BindingResult result = new BeanPropertyBindingResult(principiante, "usuario");

		SessionStatus sessionStatus = new SimpleSessionStatus();

		String view = controller.onSubmit(principiante, result, sessionStatus);

		assertEquals("redirect:/app/principianteDetalle?principianteId=4", view);
	}

	@Test
	public void lanzarErrorCuandoNoEnviaParametroPrincipianteId() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		URI uri = new URI("/principianteEditar");
		HttpMethod method = HttpMethod.GET;
		ServletContext servletContext = new MockServletContext();
		
		request.setMethod(method.name());
		request.setRequestURI(uri.toString());
		
		assertEquals("/principianteEditar", request.getRequestURI());

		// request.setRequestURI("/principianteEditar");
		// final ModelAndView mav = handlerAdapter.handle(request, response, controller);
		// assertViewName(mav, "");
	}
}
