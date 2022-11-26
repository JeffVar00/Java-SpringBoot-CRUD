package cr.ac.una.Proyecto1Paradigmas.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Vehiculo implements Serializable {

	public Vehiculo() {

	}

	public Vehiculo(Long id_Vehiculo, String placa, Tipo_Vehiculo tipo_Vehiculo) {
		this.id_Vehiculo = id_Vehiculo;
		this.placa = placa;
		this.tipo_Vehiculo = tipo_Vehiculo;
	}
	
	
	public Long getId_Vehiculo() {
		return id_Vehiculo;
	}

	public void setId_Vehiculo(Long id_Vehiculo) {
		this.id_Vehiculo = id_Vehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Tipo_Vehiculo getTipo_Vehiculo() {
		return tipo_Vehiculo;
	}

	public void setTipo_Vehiculo(Tipo_Vehiculo tipo_Vehiculo) {
		this.tipo_Vehiculo = tipo_Vehiculo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Vehiculo;

	@Column(unique = true)
	private String placa;
	
	@OneToOne
	@JoinColumn(name = "tipo_vehiculo_id", referencedColumnName = "id_Tipo_Vehiculo")
	private Tipo_Vehiculo tipo_Vehiculo;

}
