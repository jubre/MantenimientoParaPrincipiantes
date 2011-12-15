package pe.jubre.mpp.dao;

import java.util.List;

import pe.jubre.mpp.model.Estado;

public interface EstadoDao extends GenericDao<Estado, Integer>{

	List<Estado> filtroPorEstadoParaFormularios();
}
