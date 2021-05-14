package rw.ac.rca.classaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rw.ac.rca.classaapp.model.Mark;
import rw.ac.rca.classaapp.model.Student;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long>{

}
