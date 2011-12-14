package pe.jubre.mpp.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRINCIPIANTE")
public class Principiante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRINCIPIANTE_ID", nullable = false, unique = true)
	private Long principianteId;
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	@Column(name = "APELLIDO_PATERNO", nullable = false)
	private String apellidoPaterno;
	@Column(name = "APELLIDO_MATERNO", nullable = false)
	private String apellidoMaterno;
	@ManyToOne
	@JoinColumn(name = "ESTADO_ID", nullable = false)
	private Estado estado;

	@Embedded
	private Auditor auditor;

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

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Auditor getAuditor() {
		return auditor;
	}

	public void setAuditor(Auditor auditor) {
		this.auditor = auditor;
	}

}
