package rw.ac.rca.classaapp.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rw.ac.rca.classaapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmailOrUsernameOrMobile(String login, String login2, String login3);

	Optional<User> findByEmail(String login);

	Optional<User> findByEmailOrUsername(String login, String login2);

	boolean existsByEmail(String email);

	boolean existsByMobile(String mobile);
}
