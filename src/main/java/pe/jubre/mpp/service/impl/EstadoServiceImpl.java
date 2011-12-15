package pe.jubre.mpp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.jubre.mpp.dao.EstadoDao;
import pe.jubre.mpp.model.Estado;
import pe.jubre.mpp.service.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	private EstadoDao estadoDao;

	@Override
	public List<Estado> obtenerListaEstados() {
		return estadoDao.findAll(Estado.class);
	}

	@Override
	public List<Estado> obtenerListaEstadosParaFormularios() {
		return estadoDao.filtroPorEstadoParaFormularios();
	}

}
