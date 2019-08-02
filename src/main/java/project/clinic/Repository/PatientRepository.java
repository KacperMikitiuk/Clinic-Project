package project.clinic.Repository;

import org.springframework.data.repository.CrudRepository;
import project.clinic.Model.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
