package pe.jubre.mpp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import pe.jubre.mpp.model.Estado;
import pe.jubre.mpp.model.Principiante;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mpp/system-test-config.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class PrincipianteDaoTest {

	@Autowired
	private PrincipianteDao principianteDao;

	@Test
	public void verificarBusquedaDeTodos() {
		List<Principiante> principiante = principianteDao.findAll(Principiante.class);
		assertEquals(3, principiante.size());
	}

	@Test
	public void verificarBusquedaPorIdentificadorUnico() {
		Principiante principiante = principianteDao.findByPK(Principiante.class, new Long(1));
		assertEquals(new Long(1), principiante.getPrincipianteId());
	}

	@Test
	public void verificarActualizacion() {
		Principiante principiante = principianteDao.findByPK(Principiante.class, new Long(1));
		principiante.setNombre("Lexintong");
		principianteDao.update(principiante);
		principiante = principianteDao.findByPK(Principiante.class, new Long(1));
		assertEquals("Lexintong", principiante.getNombre());
	}

	@Test
	public void verificarEliminacion() {
		Principiante principiante = principianteDao.findByPK(Principiante.class, new Long(1));
		principianteDao.remove(principiante);
		List<Principiante> principiantes = principianteDao.findAll(Principiante.class);
		assertEquals(2, principiantes.size());
	}

	@Test
	public void verificarInsercion() {
		Principiante principiante = new Principiante();
		principiante.setNombre("Henry");
		principiante.setApellidoPaterno("Paterno");
		principiante.setApellidoMaterno("Materno");
		Estado estado = new Estado();
		estado.setEstadoId(1);
		principiante.setEstado(estado);
		principianteDao.insert(principiante);
		List<Principiante> principiantes = principianteDao.findAll(Principiante.class);
		assertEquals(4, principiantes.size());
	}

	@Test
	public void verificarCampoDeAuditoriaFechaCreacionNoNulo() {
		Principiante principiante = principianteDao.findByPK(Principiante.class, new Long(1));
		assertNotNull(principiante.getAuditor().getFechaCreacion());
	}
}
