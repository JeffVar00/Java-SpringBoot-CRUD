package cr.ac.una.Proyecto1Paradigmas.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipo_Vehiculo implements Serializable {

        public Tipo_Vehiculo(){

        }

	public Tipo_Vehiculo(Long id_Tipo_Vehiculo, String descripcion) {
		this.id_Tipo_Vehiculo = id_Tipo_Vehiculo;
		this.descripcion = descripcion;
	}
		
		

        public Long getId_Tipo_Vehiculo() {
            return id_Tipo_Vehiculo;
        }

        public void setId_Tipo_Vehiculo(Long id_Tipo_Vehiculo) {
            this.id_Tipo_Vehiculo = id_Tipo_Vehiculo;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id_Tipo_Vehiculo;

        private String descripcion;
}

