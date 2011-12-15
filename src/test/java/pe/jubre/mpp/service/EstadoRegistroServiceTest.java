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

import pe.jubre.mpp.model.EstadoRegistro;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mpp/system-test-config.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class EstadoRegistroServiceTest {
	
	@Autowired
	private EstadoRegistroService estadoRegistroService;
	
	@Test
	public void obtenerListaEstados() {
		List<EstadoRegistro> estadoRegistros = estadoRegistroService.obtenerListaEstadoRegistros();
		assertEquals(4, estadoRegistros.size());
	}

}
