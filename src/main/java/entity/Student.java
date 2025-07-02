package entity;

import java.time.LocalDateTime;

public class Student {

	private int rollNo;

	private String firstName;

	private String lastName;

	private String email;

	private String gender;

	private LocalDateTime addDate;

	private LocalDateTime lastUpdate;

	public Student() {
		//
	}

	public Student(int rollNo, String firstName, String lastName, String email, String gender, LocalDateTime addDate,
			LocalDateTime lastUpdate) {
		
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.addDate = addDate;
		this.lastUpdate = lastUpdate;
	}
	
	public Student(int rollNo, String firstName, String lastName, String email, String gender) {
		
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		
	}
	
	 public Student(String firstName, String lastName, String email, String gender) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.gender = gender;
	    }

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDateTime getAddDate() {
		return addDate;
	}

	public void setAddDate(LocalDateTime addDate) {
		this.addDate = addDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", addDate=" + addDate + ", lastUpdate=" + lastUpdate + "]";
	}
	
	
	
	
	
	
	

}
