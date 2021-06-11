package rw.ac.rca.classaapp.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rw.ac.rca.classaapp.enums.ERoleName;
import rw.ac.rca.classaapp.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(ERoleName roleName);
}
