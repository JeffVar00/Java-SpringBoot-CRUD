package cr.ac.una.Proyecto1Paradigmas.api;

import cr.ac.una.Proyecto1Paradigmas.entity.Tipo_Vehiculo;
import cr.ac.una.Proyecto1Paradigmas.entity.Vehiculo;
import cr.ac.una.Proyecto1Paradigmas.repository.Tipo_VehiculoRepository;
import cr.ac.una.Proyecto1Paradigmas.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/vehiculo")
public class VehiculoRest {

	@Autowired
	private VehiculoRepository vehiculoRepository;

	@Autowired
	private Tipo_VehiculoRepository Tipo_VehiculoRepository;

	@GetMapping
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<List<Vehiculo>> findAll() {
		List<Vehiculo> list = new ArrayList<Vehiculo>();
		vehiculoRepository.findAll().forEach(e -> list.add(e));
		return ResponseEntity.ok(list);
	}

	@PostMapping
	@CrossOrigin(origins = "*", maxAge = 3600) // create
	public ResponseEntity<Vehiculo> create(@RequestBody Vehiculo vehiculo) {
		return ResponseEntity.ok(vehiculoRepository.save(vehiculo));
	}

	@GetMapping("/{id}")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<Vehiculo> findById(@PathVariable Long id) {
		Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);
		if (!vehiculo.isPresent()) {
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(vehiculo.get());
	}

	@PutMapping
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<Vehiculo> update(@RequestBody Vehiculo vehiculo) {
		if (!vehiculoRepository.findById(vehiculo.getId_Vehiculo()).isPresent()) {
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(vehiculoRepository.save(vehiculo));
	}

	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity delete(@PathVariable Long id) {
		if (!vehiculoRepository.findById(id).isPresent()) {
			ResponseEntity.badRequest().build();
		}
		vehiculoRepository.delete(vehiculoRepository.findById(id).get());
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<Vehiculo> update(@RequestBody Vehiculo vehiculo, @PathVariable Long id) {
		if (!vehiculoRepository.findById(vehiculo.getId_Vehiculo()).isPresent()
				&& !Tipo_VehiculoRepository.findById(id).isPresent()) {
			ResponseEntity.badRequest().build();
		}
		Tipo_Vehiculo tipo = Tipo_VehiculoRepository.findById(id).orElse(null);
		vehiculo.setTipo_Vehiculo(tipo);
		return ResponseEntity.ok(vehiculoRepository.save(vehiculo));
	}

}
