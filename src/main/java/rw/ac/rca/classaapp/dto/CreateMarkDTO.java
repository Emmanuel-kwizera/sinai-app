package rw.ac.rca.classaapp.dto;

import com.sun.istack.NotNull;

public class CreateMarkDTO {

	@NotNull
	private int max;
	
	@NotNull
	private int scored;
	
	@NotNull
	private Long student;

	@NotNull
	private Long course;

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getScored() {
		return scored;
	}

	public void setScored(int scored) {
		this.scored = scored;
	}

	public Long getStudent() {
		return student;
	}

	public void setStudent(Long student) {
		this.student = student;
	}

	public Long getCourse() {
		return course;
	}

	public void setCourse(Long course) {
		this.course = course;
	}
	
}
