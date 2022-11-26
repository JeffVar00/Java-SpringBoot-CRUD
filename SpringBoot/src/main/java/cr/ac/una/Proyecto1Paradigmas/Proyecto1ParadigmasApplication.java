package cr.ac.una.Proyecto1Paradigmas;

import cr.ac.una.Proyecto1Paradigmas.entity.Alquiler;
import cr.ac.una.Proyecto1Paradigmas.entity.Persona;
import cr.ac.una.Proyecto1Paradigmas.entity.Tipo_Vehiculo;
import cr.ac.una.Proyecto1Paradigmas.entity.Vehiculo;
import cr.ac.una.Proyecto1Paradigmas.repository.AlquilerRepository;
import cr.ac.una.Proyecto1Paradigmas.repository.PersonaRepository;
import cr.ac.una.Proyecto1Paradigmas.repository.Tipo_VehiculoRepository;
import cr.ac.una.Proyecto1Paradigmas.repository.VehiculoRepository;
import java.util.Date;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;


@SpringBootApplication

public class Proyecto1ParadigmasApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proyecto1ParadigmasApplication.class, args);
	}






}
