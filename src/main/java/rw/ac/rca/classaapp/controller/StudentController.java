package rw.ac.rca.classaapp.controller;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import rw.ac.rca.classaapp.dto.CreateStudentDTO;
import rw.ac.rca.classaapp.model.Mark;
import rw.ac.rca.classaapp.model.Student;
import rw.ac.rca.classaapp.repository.MarkRepository;
import rw.ac.rca.classaapp.repository.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private MarkRepository markRepository;
	
	@GetMapping
	public List<Student> getAll(){
		return studentRepository.findAll();
	}
	
	@PostMapping
	public Student save(@RequestBody Student student) {

		studentRepository.save(student);
	
		return student;
	}
	
	@PostMapping
	public Mark registerStudent(@RequestBody CreateStudentDTO dto) {

		///set student
		Student student = new Student();
		student.setNames(dto.getNames());
		student.setSchoolName(dto.getSchoolName());
		studentRepository.save(student);
		
		//set marks
		Mark mark = new Mark();
		mark.setMax(dto.getMax());
		mark.setScored(dto.getScored());
		mark.setStudent(student);
		markRepository.save(mark);
		
		return mark;
	}
	
}
