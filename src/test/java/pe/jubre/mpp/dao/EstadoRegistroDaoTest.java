package pe.jubre.mpp.dao;

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
public class EstadoRegistroDaoTest {

	@Autowired
	private EstadoRegistroDao estadoRegistroDao;
	
	@Test
	public void verificarBusquedaDeTodos(){
		List<EstadoRegistro> estadoRegistros = estadoRegistroDao.findAll(EstadoRegistro.class);
		assertEquals(4, estadoRegistros.size());
	}
}
