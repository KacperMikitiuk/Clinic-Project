package project.clinic.Repository;

import org.springframework.data.repository.CrudRepository;
import project.clinic.Model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Integer> {
}
