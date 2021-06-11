package rw.ac.rca.classaapp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rw.ac.rca.classaapp.dto.CreateMarkDTO;
import rw.ac.rca.classaapp.model.Course;
import rw.ac.rca.classaapp.model.Mark;
import rw.ac.rca.classaapp.model.Student;
import rw.ac.rca.classaapp.repository.ICourseRepository;
import rw.ac.rca.classaapp.repository.IMarkRepository;
import rw.ac.rca.classaapp.repository.IStudentRepository;
import rw.ac.rca.classaapp.services.IMarkService;
import rw.ac.rca.classaapp.utils.APIResponse;

@RestController
@RequestMapping("/api/marks")
public class MarkController {

	@Autowired
	private IMarkRepository markRepository;

	@Autowired
	private IStudentRepository studentRepository;

	@Autowired
	private ICourseRepository courseRepository;

	@Autowired
	private IMarkService markService;

	@GetMapping
	public List<Mark> getAll() {
		return markRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Optional<Mark> mark = markRepository.findById(id);
		if (mark.isPresent()) {
			return ResponseEntity.ok(mark.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new APIResponse("Mark with id:" + id + " is not found", false));
	}
	@GetMapping("/code/{code}/student/{id}")
	public ResponseEntity<?> getByName(@PathVariable(value="code") String courseCode,@PathVariable(value="id") Long studentId) {
		Optional<Student> student = studentRepository.findById(studentId);
		if (!student.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new APIResponse("Student with id:" + studentId + " is not found", false));
		}
		Optional<Course> course =courseRepository.findByCode(courseCode);
		
		if (!course.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new APIResponse("Course with code:" +courseCode + " is not found", false));
		}
		List<Mark> marks= markRepository.findAllByCourseAndStudent(course.get(),student.get());
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(marks);
	}

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody CreateMarkDTO dto) {

		Optional<Student> student = studentRepository.findById(dto.getStudent());
		if (!student.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new APIResponse("Student with id:" + dto.getStudent() + " is not found", false));
		}
		Optional<Course> course = courseRepository.findById(dto.getCourse());
		if (!course.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new APIResponse("Course with id:" + dto.getCourse() + " is not found", false));
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(markService.save(dto, student.get(), course.get()));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody CreateMarkDTO dto, @PathVariable Long id) {

		Optional<Mark> mark = markRepository.findById(id);
		if (!mark.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new APIResponse("Mark with id:" + id + " is not found", false));
		}

		Optional<Student> student = studentRepository.findById(dto.getStudent());
		if (!student.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new APIResponse("Student with id:" + dto.getStudent() + " is not found", false));
		}
		Optional<Course> course = courseRepository.findById(dto.getCourse());
		if (!course.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new APIResponse("Course with id:" + dto.getCourse() + " is not found", false));
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(markService.save(dto, student.get(), course.get(), id));
	}

}
