package pe.jubre.mpp.service;

import java.util.List;
import pe.jubre.mpp.model.Principiante;

public interface PrincipianteService {

	List<Principiante> obtenerListaPrincipiantes();

	Principiante obtenerPrincipiantePorId(Long id);

	void agregarPrincipiante(Principiante principiante);

	void actualizarPrincipiante(Principiante principiante);

	void eliminarPrincipiante(Principiante principiante);
}
