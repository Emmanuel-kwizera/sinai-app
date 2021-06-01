package rw.ac.rca.classaapp.services;

import rw.ac.rca.classaapp.dto.CreateMarkDTO;
import rw.ac.rca.classaapp.model.Course;
import rw.ac.rca.classaapp.model.Mark;
import rw.ac.rca.classaapp.model.Student;

public interface IMarkService{
	
	public Mark save(CreateMarkDTO dto, Student student, Course course);

	public Mark save(CreateMarkDTO dto, Student student, Course course,Long id);

}
