package pe.jubre.mpp.dao.hibernate;

import org.springframework.stereotype.Repository;

import pe.jubre.mpp.dao.EstadoRegistroDao;
import pe.jubre.mpp.model.EstadoRegistro;

@Repository
public class EstadoRegistroDaoHibernate extends GenericDaoHibernate<EstadoRegistro, Integer> implements EstadoRegistroDao {

}
