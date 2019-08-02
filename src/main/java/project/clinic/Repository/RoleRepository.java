package project.clinic.Repository;

import org.springframework.data.repository.CrudRepository;
import project.clinic.Model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
