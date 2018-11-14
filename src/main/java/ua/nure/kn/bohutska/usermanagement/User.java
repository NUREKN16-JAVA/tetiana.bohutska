package ua.nure.kn.bohutska.usermanagement;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


public class User implements Serializable {

	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	
	public User(Long id, String firstName, String lastName,Date dateofBirth) {
      
		this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateofBirth;
        
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Object getFullName() {

		return getLastName() + "," + getFirstName();
	}

	public int getAge() throws Exception {
		Calendar calendar = Calendar.getInstance();
		Calendar dateOfBirth = Calendar.getInstance();
		
		dateOfBirth.setTime(getDateOfBirth());
		
		int currentYear = calendar.get(Calendar.YEAR);
		int yearOfBirth = dateOfBirth.get(Calendar.YEAR);
		
		if ((currentYear==yearOfBirth)||(currentYear<yearOfBirth)) throw new Exception();
		
		if ((dateOfBirth.get(Calendar.MONTH) > calendar.get(Calendar.MONTH)) ||
				((dateOfBirth.get(Calendar.DAY_OF_MONTH) > calendar.get(Calendar.DAY_OF_MONTH)))&&((dateOfBirth.get(Calendar.MONTH) == calendar.get(Calendar.MONTH))))
			return (currentYear-yearOfBirth - 1);
	
		else return(currentYear-yearOfBirth);
		
		
	}
}
