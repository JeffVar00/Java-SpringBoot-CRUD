package cr.ac.una.Proyecto1Paradigmas.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Alquiler implements Serializable {

	public Alquiler() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Alquiler;

	@OneToOne
	@JoinColumn(name = "persona_id", referencedColumnName = "id_Persona")
	private Persona persona;

	@OneToOne
	@JoinColumn(name = "vehiculo_id", referencedColumnName = "id_Vehiculo")
	private Vehiculo vehiculo;

	
	    @JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha;

	public Alquiler(Long id_Alquiler, Persona persona, Vehiculo vehiculo, Date fecha) {
		this.id_Alquiler = id_Alquiler;
		this.persona = persona;
		this.vehiculo = vehiculo;
		this.fecha = fecha;
	}

	public Long getId_Alquiler() {
		return id_Alquiler;
	}

	public void setId_Alquiler(Long id_Alquiler) {
		this.id_Alquiler = id_Alquiler;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
