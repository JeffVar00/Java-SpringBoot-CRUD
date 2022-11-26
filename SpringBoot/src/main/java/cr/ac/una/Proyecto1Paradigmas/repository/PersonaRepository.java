package cr.ac.una.Proyecto1Paradigmas.repository;

import cr.ac.una.Proyecto1Paradigmas.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

}
