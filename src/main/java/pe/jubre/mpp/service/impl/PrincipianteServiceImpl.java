package pe.jubre.mpp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.jubre.mpp.dao.PrincipianteDao;
import pe.jubre.mpp.model.Principiante;
import pe.jubre.mpp.service.PrincipianteService;

@Service
public class PrincipianteServiceImpl implements PrincipianteService{

	@Autowired
	private PrincipianteDao principianteDao;

	public List<Principiante> obtenerListaPrincipiantes() {
		return principianteDao.findAll(Principiante.class);
	}

	public Principiante obtenerPrincipiantePorId(Long id) {
		return principianteDao.findByPK(Principiante.class, id);
	}

	public void agregarPrincipiante(Principiante principiante) {
		principianteDao.insert(principiante);
	}

	public void actualizarPrincipiante(Principiante principiante) {
		principianteDao.update(principiante);
	}

	public void eliminarPrincipiante(Principiante principiante) {
		principianteDao.remove(principiante);
	}
}
