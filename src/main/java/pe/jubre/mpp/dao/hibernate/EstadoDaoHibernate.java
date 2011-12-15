package pe.jubre.mpp.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import pe.jubre.mpp.dao.EstadoDao;
import pe.jubre.mpp.model.Estado;
import pe.jubre.mpp.util.EstadoEnum;

@Repository
public class EstadoDaoHibernate extends GenericDaoHibernate<Estado, Integer> implements EstadoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> filtroPorEstadoParaFormularios() {
		List<Integer> idEstadosParaFormularios = cargaListaConEstadosParaFormularios();
		Query query = em.createQuery("from Estado where estadoId in (:parametroEstados)");
		query.setParameter("parametroEstados", idEstadosParaFormularios);
		return query.getResultList();
	}

	private List<Integer> cargaListaConEstadosParaFormularios() {
		List<Integer> idEstadosParaFormularios = new ArrayList<Integer>();
		idEstadosParaFormularios.add(EstadoEnum.ACTIVO.valor);
		idEstadosParaFormularios.add(EstadoEnum.INACTIVO.valor);
		return idEstadosParaFormularios;
	}

}
