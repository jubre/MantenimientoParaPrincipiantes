package pe.jubre.mpp.dao.hibernate;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pe.jubre.mpp.dao.GenericDao;

public class GenericDaoHibernate<T, pk extends Serializable> implements GenericDao<T, pk> {

	@Autowired
	@PersistenceContext(unitName = "mpp-PU")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> typeClass) {
		List<T> results = em.createQuery("from " + typeClass.getSimpleName()).getResultList();
		if (results == null)
			return Collections.emptyList();
		return results;
	}

	public T findByPK(Class<T> typeClass, pk id) {
		return em.find(typeClass, id);
	}

	@Transactional(readOnly = false)
	public void update(T object) {
		em.merge(object);
	}

	@Transactional(readOnly = false)
	public void remove(T object) {
		em.remove(em.merge(object));
	}

	@Transactional(readOnly = false)
	public void insert(T object) {
		em.persist(object);
	}
}
