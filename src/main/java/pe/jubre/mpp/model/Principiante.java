package pe.jubre.mpp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PRINCIPIANTE")
public class Principiante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRINCIPIANTE_ID", nullable = false, unique = true)
	private Long principianteId;
	@Column(name = "NOMBRE")
	private String nombre;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;

	public Principiante() {
	}

	public Long getPrincipianteId() {
		return principianteId;
	}

	public void setPrincipianteId(Long principianteId) {
		this.principianteId = principianteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}
