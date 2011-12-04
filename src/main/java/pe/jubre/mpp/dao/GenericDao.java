package pe.jubre.mpp.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
	List<T> findAll(Class<T> typeClass);

	T findByPK(Class<T> typeClass, PK id);

	void update(T object);

	void remove(T object);

	void insert(T object);
}
