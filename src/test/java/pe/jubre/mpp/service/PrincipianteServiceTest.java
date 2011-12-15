package pe.jubre.mpp.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pe.jubre.mpp.model.Principiante;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mpp/system-test-config.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class PrincipianteServiceTest {

	@Autowired
	private PrincipianteService principianteService;

	@Test
	public void obtenerListaPrincipiantes() {
		List<Principiante> principiantes = principianteService.obtenerListaPrincipiantes();
		assertEquals(10, principiantes.size());
	}

	@Test
	public void obtenerPrincipiantePorId() {
		Principiante principiante = principianteService.obtenerPrincipiantePorId(new Long(1));
		assertEquals(new Long(1), principiante.getPrincipianteId());
	}
}
