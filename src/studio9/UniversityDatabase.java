package studio9;

import assignment7.Student;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	private final Map<String, Student> students = new HashMap();
	
	
	public UniversityDatabase(){
	}
	
	public void addStudent(String accountName, Student student) {
		this.students.put(accountName, student);
	}

	public int getStudentCount() {
		return this.students.size();
	}

	public String lookupFullName(String accountName) {
		if (this.students.get(accountName) == null) {
			return null;
		}

		Student selected = this.students.get(accountName);
		
		return selected.getFullName();
	}

	public double getTotalBearBucks() {
		double totalBB = 0.0;
		
		for (Student student: this.students.values()) {
			totalBB = totalBB + student.getBearBucksBalance();
		}
		return totalBB;
		
	}
}
