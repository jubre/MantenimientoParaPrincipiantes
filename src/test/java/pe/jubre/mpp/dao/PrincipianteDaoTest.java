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

import pe.jubre.mpp.dao.PrincipianteDao;
import pe.jubre.mpp.model.Principiante;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mpp/system-test-config.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class PrincipianteDaoTest {

	@Autowired
	private PrincipianteDao principianteDao;

	@Test
	public void findAll() {
		List<Principiante> principiante = principianteDao.findAll(Principiante.class);
		assertEquals(3, principiante.size());
	}

	@Test
	public void findByPK() {
		Principiante principiante = principianteDao.findByPK(Principiante.class, new Long(1));
		assertEquals(new Long(1), principiante.getPrincipianteId());		
	}

	@Test
	public void update() {
		Principiante principiante = principianteDao.findByPK(Principiante.class, new Long(1));
		principiante.setNombre("Lexintong");
		principianteDao.update(principiante);
		principiante = principianteDao.findByPK(Principiante.class, new Long(1));		
		assertEquals("Lexintong", principiante.getNombre());
	}

	@Test
	public void delete() {
		Principiante principiante = principianteDao.findByPK(Principiante.class, new Long(1));
		principianteDao.remove(principiante);
		List<Principiante> principiantes = principianteDao.findAll(Principiante.class);
		assertEquals(2, principiantes.size());
	}

	@Test
	public void insert() {
		Principiante principiante = new Principiante();
		principiante.setNombre("Henry");
		principianteDao.insert(principiante);
		List<Principiante> principiantes = principianteDao.findAll(Principiante.class);
		assertEquals(4, principiantes.size());
	}
}
