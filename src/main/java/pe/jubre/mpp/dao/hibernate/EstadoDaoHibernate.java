package pe.jubre.mpp.dao.hibernate;

import org.springframework.stereotype.Repository;

import pe.jubre.mpp.dao.EstadoDao;
import pe.jubre.mpp.model.Estado;

@Repository
public class EstadoDaoHibernate extends GenericDaoHibernate<Estado, Integer> implements EstadoDao {

}
