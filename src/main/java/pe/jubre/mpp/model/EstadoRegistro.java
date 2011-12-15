package pe.jubre.mpp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADO_REGISTRO")
public class EstadoRegistro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ESTADO_REGISTRO_ID", nullable = false, unique = true)
	private Integer estadoRegistroId;

	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;

	public EstadoRegistro() {
	}

	public Integer getEstadoRegistroId() {
		return estadoRegistroId;
	}

	public void setEstadoRegistroId(Integer estadoRegistroId) {
		this.estadoRegistroId = estadoRegistroId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
