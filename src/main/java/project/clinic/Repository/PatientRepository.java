package project.clinic.Repository;

import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.UserDatabase;
import org.springframework.data.repository.CrudRepository;
import project.clinic.Model.Patient;

import java.security.Principal;
import java.util.Iterator;

public interface PatientRepository extends CrudRepository<Patient, Integer>{
    Patient findByEmail(String email);
}
