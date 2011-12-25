package pe.jubre.mpp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.jubre.mpp.dao.SexoDao;
import pe.jubre.mpp.model.Sexo;
import pe.jubre.mpp.service.SexoService;

@Service
public class SexoServiceImpl implements SexoService {
	
	@Autowired
	private SexoDao sexoDao;

	@Override
	public List<Sexo> obtenerListaSexos() {
		return sexoDao.findAll(Sexo.class);
	}

}
