package pe.jubre.mpp.service;

import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import pe.jubre.mpp.model.Sexo;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mpp/system-test-config.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class SexoServiceTest {

	@Autowired
	private SexoService sexoService;
	
	@Test
	public void obtenerListaSexos(){
		List<Sexo> sexos = sexoService.obtenerListaSexos();
		assertEquals(2, sexos.size());
	}
	
}
