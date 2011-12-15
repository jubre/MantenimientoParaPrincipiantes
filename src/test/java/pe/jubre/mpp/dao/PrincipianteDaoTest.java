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
import pe.jubre.mpp.util.EstadoEnum;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mpp/system-test-config.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class PrincipianteDaoTest {

	@Autowired
	private PrincipianteDao principianteDao;

	@Autowired
	private EstadoDao estadoDao;

	@Test
	public void verificarBusquedaDeTodos() {
		List<Principiante> principiante = principianteDao.findAll(Principiante.class);
		assertEquals(10, principiante.size());
	}

	@Test
	public void verificarBusquedaPorIdentificadorUnico() {
		Principiante principiante = principianteDao.findByPK(Principiante.class, new Long(1));
		assertEquals(new Long(1), principiante.getPrincipianteId());
	}

	@Test
	public void verificarActualizacion() {
		Principiante principiante = principianteDao.findByPK(Principiante.class, new Long(1));
		principiante.setNombre("Mark");
		principianteDao.update(principiante);
		principiante = principianteDao.findByPK(Principiante.class, new Long(1));
		assertEquals("Mark", principiante.getNombre());
	}

	@Test
	public void verificarEliminacion() {
		Principiante principiante = principianteDao.findByPK(Principiante.class, new Long(1));
		principianteDao.remove(principiante);
		List<Principiante> principiantes = principianteDao.findAll(Principiante.class);
		assertEquals(9, principiantes.size());
	}

	@Test
	public void verificarInsercion() {
		Principiante principiante = new Principiante();
		principiante.setNombre("Henry");
		principiante.setApellidoPaterno("Paterno");
		principiante.setApellidoMaterno("Materno");
		principiante.setEstado(estadoDao.findByPK(Estado.class, EstadoEnum.ACTIVO.valor));
		principianteDao.insert(principiante);
		List<Principiante> principiantes = principianteDao.findAll(Principiante.class);
		assertEquals(11, principiantes.size());
	}

	@Test
	public void verificarDescripcionDelEstadoLuegoDeUnaInsercion() {
		Principiante principiante = new Principiante();
		principiante.setNombre("Henry");
		principiante.setApellidoPaterno("Paterno");
		principiante.setApellidoMaterno("Materno");
		principiante.setEstado(estadoDao.findByPK(Estado.class, EstadoEnum.ACTIVO.valor));
		principianteDao.insert(principiante);
		Principiante principianteParaValidar = principianteDao.findByPK(Principiante.class, principiante.getPrincipianteId());
		assertEquals("Activo", principianteParaValidar.getEstado().getDescripcion());
	}

	@Test
	public void verificarCampoDeAuditoriaFechaCreacionNoNull() {
		Principiante principiante = principianteDao.findByPK(Principiante.class, new Long(1));
		assertNotNull(principiante.getAuditor().getFechaCreacion());
	}

	@Test
	public void verificarFiltroPorCampoEstado() {
		List<Principiante> principiantes = principianteDao.filtroPorEstado(EstadoEnum.ACTIVO.valor);
		assertEquals(8, principiantes.size());
	}
}
