package cr.ac.una.Proyecto1Paradigmas.repository;

import cr.ac.una.Proyecto1Paradigmas.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log,Long> {
}
