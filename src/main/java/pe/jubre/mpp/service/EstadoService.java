package pe.jubre.mpp.service;

import java.util.List;

import pe.jubre.mpp.model.Estado;

public interface EstadoService {

	List<Estado> obtenerListaEstados();
	
	List<Estado> obtenerListaEstadosParaFormularios();

}
