package pe.jubre.mpp.webapp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

import pe.jubre.mpp.dao.EstadoDao;
import pe.jubre.mpp.dao.EstadoRegistroDao;
import pe.jubre.mpp.dao.SexoDao;
import pe.jubre.mpp.model.Estado;
import pe.jubre.mpp.model.EstadoRegistro;
import pe.jubre.mpp.model.Principiante;
import pe.jubre.mpp.model.Sexo;
import pe.jubre.mpp.util.EstadoEnum;
import pe.jubre.mpp.util.EstadoRegistroEnum;
import pe.jubre.mpp.util.SexoEnum;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mpp/system-test-config.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class PrincipianteEditarControllerTest {

	@Autowired
	private PrincipianteEditarController controller;
	
	@Autowired
	private EstadoDao estadoDao;
	@Autowired
	private EstadoRegistroDao estadoRegistroDao;
	@Autowired
	private SexoDao sexoDao;

	@Test
	public void validarGet() {
		Principiante principiante = controller.setupForm(new Long(1));
		assertEquals(new Long(1), principiante.getPrincipianteId());
	}

	@Test
	public void validarPost() {
		Principiante principiante = new Principiante();
		principiante.setNombre("pele");
		principiante.setPrincipianteId(new Long(11));
		principiante.getAuditor().setFechaCreacion(new Date());
		principiante.setEstado(estadoDao.findByPK(Estado.class, EstadoEnum.ACTIVO.valor));
		principiante.setEstadoRegistro(estadoRegistroDao.findByPK(EstadoRegistro.class, EstadoRegistroEnum.ACEPTADO.valor));
		principiante.setSexo(sexoDao.findByPK(Sexo.class, SexoEnum.MASCULINO.valor));

		BindingResult result = new BeanPropertyBindingResult(principiante, "usuario");

		SessionStatus sessionStatus = new SimpleSessionStatus();

		String view = controller.onSubmit(principiante, result, sessionStatus);
		assertNull(view);

		//assertEquals("redirect:/app/principianteDetalle?principianteId=11", view);
	}
}
