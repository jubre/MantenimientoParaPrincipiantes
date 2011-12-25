package pe.jubre.mpp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SEXO")
public class Sexo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SEXO_ID", nullable = false, unique = true)
	private Integer sexoId;

	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;

	public Sexo() {
	}

	public Integer getSexoId() {
		return sexoId;
	}

	public void setSexoId(Integer sexoId) {
		this.sexoId = sexoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
