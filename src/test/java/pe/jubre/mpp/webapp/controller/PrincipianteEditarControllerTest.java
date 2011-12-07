package pe.jubre.mpp.webapp.controller;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.support.SimpleSessionStatus;
import pe.jubre.mpp.model.Principiante;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mpp/system-test-config.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class PrincipianteEditarControllerTest {

	@Autowired
	private PrincipianteEditarController controller;

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
}
