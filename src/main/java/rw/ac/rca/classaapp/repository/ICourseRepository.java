package rw.ac.rca.classaapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rw.ac.rca.classaapp.model.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long>{

	Optional<Course> findByCode(String courseCode);
	
}
