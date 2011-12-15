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

import pe.jubre.mpp.model.Estado;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mpp/system-test-config.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class EstadoDaoTest {

	@Autowired
	private EstadoDao estadoDao;

	@Test
	public void verificarFiltroDeEstadosParaFormularios() {
		List<Estado> estados = estadoDao.filtroPorEstadoParaFormularios();
		assertEquals(2, estados.size());
	}
}
