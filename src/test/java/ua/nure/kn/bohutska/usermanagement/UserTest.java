package ua.nure.kn.bohutska.usermanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;


 public class UserTest {

	private User user;
	private Date dateOfBirth;
	
	
	@Before
	public void setUp() throws Exception{
		
		Date date = new SimpleDateFormat("dd-MM-yyyy").parse("25-01-1999");
		user = new User(1L,"Tanya","Bogutskaya",date);
	  
	}

	@Test
	 public void testGetFullName () {
		
		assertEquals("Bogutskaya,Tanya", user.getFullName());
		
	}
	//verify 
	@Test
	 public void testGetAgeEqualMonthAndDay () throws Exception  {
		
		Calendar calendar = Calendar.getInstance(); 
		calendar.set(1999, Calendar.NOVEMBER, 14);
		dateOfBirth = calendar.getTime();
		
		user.setDateOfBirth(dateOfBirth);
		assertEquals(19,user.getAge());

	}
	@Test
	 public void testGetAgeEqualMonthAndDayTomorrow () throws Exception  { 
		
		Calendar calendar = Calendar.getInstance(); 
		calendar.set(1999, Calendar.NOVEMBER, 16);
		dateOfBirth = calendar.getTime();
		
		user.setDateOfBirth(dateOfBirth);
		assertEquals(18,user.getAge());
	}
	@Test
	 public void testGetAgeEqualDayAndNextMonth () throws Exception   { 
		Calendar calendar = Calendar.getInstance(); 
		calendar.set(1999, Calendar.DECEMBER, 14);
		dateOfBirth = calendar.getTime();
		
		user.setDateOfBirth(dateOfBirth);
		assertEquals(18,user.getAge());
	}
	@Test
	 public void testGetAgeMonthBefore () throws Exception  { 
		
		Calendar calendar = Calendar.getInstance(); 
		calendar.set(1999, Calendar.OCTOBER, 18);
		dateOfBirth = calendar.getTime();
		
		user.setDateOfBirth(dateOfBirth);
		assertEquals(19,user.getAge());
	}
	
	@Test
	 public void testGetAgeYearEqualYearOfBirthOrInFuture () throws Exception  {
		
		try{Calendar calendar = Calendar.getInstance(); 
		calendar.set(2019, Calendar.NOVEMBER, 14);
		dateOfBirth = calendar.getTime();
		
		user.setDateOfBirth(dateOfBirth);
		assertEquals(2018-2019,user.getAge());}
		catch(Exception e) {assertNotEquals("",e.getMessage());}
		}

	}
	

