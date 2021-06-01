package rw.ac.rca.classaapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rw.ac.rca.classaapp.model.Course;
import rw.ac.rca.classaapp.model.Mark;
import rw.ac.rca.classaapp.model.Student;

@Repository
public interface IMarkRepository extends JpaRepository<Mark, Long>{

	List<Mark> findAllByCourseAndStudent(Course course, Student student);

}
