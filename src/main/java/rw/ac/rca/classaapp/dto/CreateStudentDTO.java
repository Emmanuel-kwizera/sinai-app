package rw.ac.rca.classaapp.dto;
import com.sun.istack.NotNull;

public class CreateStudentDTO {

	@NotNull
	private String names;

	@NotNull
	private String schoolName;

	@NotNull
	private int max;

	@NotNull
	private int scored;

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

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
	
	
}
