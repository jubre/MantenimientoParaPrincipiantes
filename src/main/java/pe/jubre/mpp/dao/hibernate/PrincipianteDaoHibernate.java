package pe.jubre.mpp.dao.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import pe.jubre.mpp.dao.PrincipianteDao;
import pe.jubre.mpp.model.Principiante;

@Repository
public class PrincipianteDaoHibernate extends GenericDaoHibernate<Principiante, Long> implements PrincipianteDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Principiante> filtroPorEstado(int valor) {
		Query query = em.createQuery("from Principiante where estado.estadoId=:parametroEstadoId");
		query.setParameter("parametroEstadoId", valor);
		return query.getResultList();
	}

}
