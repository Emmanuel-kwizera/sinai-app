package rw.ac.rca.classaapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.ac.rca.classaapp.dto.CreateMarkDTO;
import rw.ac.rca.classaapp.model.Course;
import rw.ac.rca.classaapp.model.Mark;
import rw.ac.rca.classaapp.model.Student;
import rw.ac.rca.classaapp.repository.IMarkRepository;
import rw.ac.rca.classaapp.services.IMarkService;

@Service
public class MarkServiceImpl implements IMarkService {
	
	@Autowired
	private IMarkRepository markRepository;
	
	@Override
	public Mark save(CreateMarkDTO dto, Student student, Course course) {
		Mark mark = new Mark();

		mark.setStudent(student);

		mark.setCourse(course);

		mark.setMax(dto.getMax());
		mark.setScored(dto.getScored());
 
		markRepository.save(mark);
		return mark;
	}

	@Override
	public Mark save(CreateMarkDTO dto, Student student, Course course, Long id) {
		Mark mark = markRepository.findById(id).get();

		mark.setStudent(student);

		mark.setCourse(course);

		mark.setMax(dto.getMax());
		mark.setScored(dto.getScored());
		
		markRepository.save(mark);
		
		return mark;
	}

}
