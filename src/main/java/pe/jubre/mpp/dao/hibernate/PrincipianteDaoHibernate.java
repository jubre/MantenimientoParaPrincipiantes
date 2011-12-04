package pe.jubre.mpp.dao.hibernate;

import org.springframework.stereotype.Repository;

import pe.jubre.mpp.dao.PrincipianteDao;
import pe.jubre.mpp.model.Principiante;

@Repository
public class PrincipianteDaoHibernate extends GenericDaoHibernate<Principiante, Long> implements PrincipianteDao{

}
