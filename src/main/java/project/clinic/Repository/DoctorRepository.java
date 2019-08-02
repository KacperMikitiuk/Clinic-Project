package project.clinic.Repository;

import org.springframework.data.repository.CrudRepository;
import project.clinic.Model.Doctor;


public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
}
