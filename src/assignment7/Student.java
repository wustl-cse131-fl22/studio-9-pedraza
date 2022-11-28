package assignment7;

public class Student {
	private String firstName;
	private String lastName;
	private int studentID;
	private int attemptedCredits;
	private int passingCredits;
	private double totalGradeQualityPoints;
	private double BearBuckBalance;
	
	public Student(String firstNameInput, String lastNameInput, int id) {
		this.firstName = firstNameInput;
		this.lastName = lastNameInput;
		this.studentID = id;
	}
	
	public String toString() {
		return this.getFullName() + " " + this.getId();
	}
	
	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}
	
	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	public int getId() {
		return this.studentID;
	}
	
	public double getBearBucksBalance() {
		return this.BearBuckBalance;
	}
	
	public void depositBearBucks(double amount) {
		BearBuckBalance = BearBuckBalance + amount;
	}
	
	public void deductBearBucks(double amount) {
		BearBuckBalance = BearBuckBalance - amount;
	}
	
	public double cashOutBearBucks() {
		if (this.BearBuckBalance <= 10) {
			this.BearBuckBalance = 0.0;
			return 0.0;
		} else {
			double returnedValue = this.BearBuckBalance - 10.0;
			this.BearBuckBalance = 0.0;
			return returnedValue;
		}
	}
	
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		String childLastName = this.lastName;
		
		// Overwrite last name if hyphenated
		if (isHyphenated == true) {
			childLastName = this.lastName + "-" + other.lastName;
		} 
		
		Student child = new Student(firstName, childLastName, id);
		child.depositBearBucks(this.cashOutBearBucks());
		child.depositBearBucks(other.cashOutBearBucks());
		
		return child;
	}
	
	// Set method as private to avoid being called from outside of class
	private int getTotalAttemptedCredits() {
		return this.attemptedCredits;
	}
	
	private int getTotalPassingCredits() {
		return this.passingCredits;
	}
	
	public void submitGrade(double grade, int credits) {
		this.attemptedCredits = this.attemptedCredits + credits;
		
		// Add credits to passingCredits only if passed the course
		if (grade > 1.7) {
			this.passingCredits = this.passingCredits + credits;
		}
		
		double curQualityPoint = grade * credits;
		this.totalGradeQualityPoints = this.totalGradeQualityPoints + curQualityPoint;
	}
	
	public double calculateGradePointAverage() {
		return totalGradeQualityPoints / attemptedCredits;
	}
	
	public boolean isEligibleForPhiBetaKappa() {
		if (this.passingCredits >= 98 && this.calculateGradePointAverage() >= 3.60) {
			return true;
		} else if (this.passingCredits >= 75 && this.calculateGradePointAverage() >= 3.80) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getClassStanding() {
		if (this.passingCredits < 30) {
			return "First Year";
		} else if (this.passingCredits >= 30 && this.passingCredits < 60) {
			return "Sophomore";
		} else if (this.passingCredits >= 60  && this.passingCredits < 90) {
			return "Junior";
		} else {
			return "Senior";
		}
	}
	
	
}