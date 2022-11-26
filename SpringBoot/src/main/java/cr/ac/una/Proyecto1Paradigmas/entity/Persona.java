package cr.ac.una.Proyecto1Paradigmas.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona implements Serializable {

    public Persona(){

    }

	public Persona(Long id_Persona, String identificacion, String nombre) {
		this.id_Persona = id_Persona;
		this.identificacion = identificacion;
		this.nombre = nombre;
	}
	

    public Long getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(Long id_Persona) {
        this.id_Persona = id_Persona;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Persona;

	@Column(unique = true)
    private String identificacion;
    private String nombre;
}
