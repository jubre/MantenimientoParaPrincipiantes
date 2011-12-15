package pe.jubre.mpp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.jubre.mpp.dao.EstadoRegistroDao;
import pe.jubre.mpp.model.EstadoRegistro;
import pe.jubre.mpp.service.EstadoRegistroService;

@Service
public class EstadoRegistroServiceImpl implements EstadoRegistroService{

	@Autowired
	private EstadoRegistroDao estadoRegistroDao;
	
	@Override
	public List<EstadoRegistro> obtenerListaEstadoRegistros() {
		return estadoRegistroDao.findAll(EstadoRegistro.class);
	}

}
