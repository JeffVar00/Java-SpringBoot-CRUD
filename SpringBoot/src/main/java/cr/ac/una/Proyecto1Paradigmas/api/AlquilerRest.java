package cr.ac.una.Proyecto1Paradigmas.api;

import cr.ac.una.Proyecto1Paradigmas.entity.Alquiler;
import cr.ac.una.Proyecto1Paradigmas.entity.Persona;
import cr.ac.una.Proyecto1Paradigmas.repository.AlquilerRepository;
import cr.ac.una.Proyecto1Paradigmas.repository.PersonaRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/alquiler")
public class AlquilerRest {

	@Autowired
	private AlquilerRepository alquilerRepository;

	@Autowired
	private PersonaRepository personaRepository;

	@GetMapping
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<List<Alquiler>> findAll() {
		List<Alquiler> list = new ArrayList<Alquiler>();
		alquilerRepository.findAll().forEach(e -> list.add(e));
		return ResponseEntity.ok(list);
	}

	@PostMapping
	@CrossOrigin(origins = "*", maxAge = 3600) // create
	public ResponseEntity<Alquiler> create(@RequestBody Alquiler alquiler)  {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		List<Alquiler> alquileres = new ArrayList();
		alquilerRepository.findAll().forEach(alquiler2 -> {
			alquileres.add(alquiler2);
		});

		for (var a : alquileres) {
			System.out.println(a.getFecha());
			System.out.println(alquiler.getFecha());
			String date1 = simpleDateFormat.format(alquiler.getFecha());
			String date2 = simpleDateFormat.format(a.getFecha());
			if (alquiler.getVehiculo().getId_Vehiculo().equals(a.getVehiculo().getId_Vehiculo())) {
				return ResponseEntity.badRequest().build();
			}

			if ( a.getPersona().getId_Persona().equals(alquiler.getPersona().getId_Persona()) && date1.equals(date2) ) {
				return ResponseEntity.badRequest().build();
			}
		}
		return ResponseEntity.ok(alquilerRepository.save(alquiler));
	}
	@GetMapping("/{id}")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<Alquiler> findById(@PathVariable Long id) {
		Optional<Alquiler> alquiler = alquilerRepository.findById(id);
		if (!alquiler.isPresent()) {
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(alquiler.get());
	}

	@PutMapping
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<Alquiler> update(@RequestBody Alquiler alquiler) {
		if (!alquilerRepository.findById(alquiler.getId_Alquiler()).isPresent()) {
			ResponseEntity.badRequest().build();
		}
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		List<Alquiler> alquileres = new ArrayList();
		alquilerRepository.findAll().forEach(alquiler2 -> {
			alquileres.add(alquiler2);
		});
		for (var a : alquileres) {
			System.out.println(a.getFecha());
			System.out.println(alquiler.getFecha());
			String date1 = simpleDateFormat.format(alquiler.getFecha());
			String date2 = simpleDateFormat.format(a.getFecha());

			if ( a.getPersona().getId_Persona().equals(alquiler.getPersona().getId_Persona()) && date1.equals(date2) ) {
				return ResponseEntity.badRequest().build();
			}
		}
		return ResponseEntity.ok(alquilerRepository.save(alquiler));
	}

	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity delete(@PathVariable Long id) {
		if (!alquilerRepository.findById(id).isPresent()) {
			ResponseEntity.badRequest().build();
		}
		alquilerRepository.delete(alquilerRepository.findById(id).get());
		return ResponseEntity.ok().build();
	}

}
