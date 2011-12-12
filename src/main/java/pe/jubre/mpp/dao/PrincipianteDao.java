package pe.jubre.mpp.dao;

import java.util.List;

import pe.jubre.mpp.model.Principiante;

public interface PrincipianteDao extends GenericDao<Principiante, Long>{

	List<Principiante> filtroPorEstado(int valor);
	
}
