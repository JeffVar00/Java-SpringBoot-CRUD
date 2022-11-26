package cr.ac.una.Proyecto1Paradigmas.api;

import cr.ac.una.Proyecto1Paradigmas.entity.Tipo_Vehiculo;
import cr.ac.una.Proyecto1Paradigmas.repository.Tipo_VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/tipo_vehiculo")
public class Tipo_VehiculoRest {
    @Autowired
    private Tipo_VehiculoRepository tipo_VehiculoRepository;

    @GetMapping
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<List<Tipo_Vehiculo>> findAll(){
        List<Tipo_Vehiculo> list = new ArrayList<Tipo_Vehiculo>();
        tipo_VehiculoRepository.findAll().forEach(e->list.add(e));
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @CrossOrigin(origins = "*", maxAge = 3600) // create
    public ResponseEntity<Tipo_Vehiculo> create(@RequestBody Tipo_Vehiculo tipo_Vehiculo){
        return ResponseEntity.ok(tipo_VehiculoRepository.save(tipo_Vehiculo));
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<Tipo_Vehiculo> findById(@PathVariable Long id) {
        Optional<Tipo_Vehiculo> tipo_Vehiculo = tipo_VehiculoRepository.findById(id);
        if (!tipo_Vehiculo.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tipo_Vehiculo.get());
    }

    @PutMapping
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity<Tipo_Vehiculo> update(@RequestBody Tipo_Vehiculo tipo_Vehiculo) {
        if (!tipo_VehiculoRepository.findById(tipo_Vehiculo.getId_Tipo_Vehiculo()).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tipo_VehiculoRepository.save(tipo_Vehiculo));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity delete(@PathVariable Long id) {
        if (!tipo_VehiculoRepository.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        tipo_VehiculoRepository.delete(tipo_VehiculoRepository.findById(id).get());
        return ResponseEntity.ok().build();
    }

}
