package pe.jubre.mpp.dao.hibernate;

import org.springframework.stereotype.Repository;

import pe.jubre.mpp.dao.SexoDao;
import pe.jubre.mpp.model.Sexo;

@Repository
public class SexoDaoHibernate extends GenericDaoHibernate<Sexo, Integer> implements SexoDao {

}
