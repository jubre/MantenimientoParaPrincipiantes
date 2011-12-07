package pe.jubre.mpp.webapp.controller;

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
import org.springframework.web.bind.ServletRequestBindingException;
import pe.jubre.mpp.model.Principiante;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mpp/system-test-config.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class PrincipianteControllerTest {

	@Autowired
	private PrincipianteController controller;

	@Test
	public void validarUsuarioListaRequest(){
		List<Principiante> principiantes =controller.principianteLista();
		assertEquals(3, principiantes.size());
	}
	
	@Test
	public void validarUsuarioDetalleRequest() throws ServletRequestBindingException{
		Principiante principiante =controller.principianteDetalle(new Long(1));
		assertNotNull(principiante);
	}
}
