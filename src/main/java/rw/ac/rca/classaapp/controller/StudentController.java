package rw.ac.rca.classaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rw.ac.rca.classaapp.dto.CreateStudentDTO;
import rw.ac.rca.classaapp.model.Mark;
import rw.ac.rca.classaapp.model.Student;
import rw.ac.rca.classaapp.repository.IMarkRepository;
import rw.ac.rca.classaapp.repository.IStudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentController {	
	@Autowired
	private IStudentRepository studentRepository;
	
	@Autowired
	private IMarkRepository markRepository;
	
	@GetMapping
	public List<Student> getAll(){
		return studentRepository.findAll();
	}
	
	@PostMapping
	public Student save(@RequestBody Student student) {

		studentRepository.save(student);
	
		return student;
	}
	
	@PostMapping("/dto")
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
