package ua.nure.kn.bohutska.usermanagement.web;


import ua.nure.kn.bohutska.usermanagement.User;

import java.text.DateFormat;
import java.util.Date;

public class AddServletTest extends MockServletTestCase {
    @Override
    public void setUp() throws Exception {
        super.setUp();
        createServlet(AddServlet.class);
    }
    public void testAdd() {
        Date date = new Date();
        User newUser = new User("Tanya", "Bogutskaya", date);
        User user = new User(new Long(1000), "Tanya", "Bogutskaya", date);
        getMockUserDao().expectAndReturn("create", newUser, user);

        addRequestParameter("firstName", "Tanya");
        addRequestParameter("lastName", "Bogutskaya");
        addRequestParameter("date", DateFormat.getDateInstance().format(date));
        addRequestParameter("okButton", "Ok");
        doPost();
    }

    public void testAddEmptyFirstName() {
        Date date = new Date();
        addRequestParameter("lastName", "Bogutskaya");
        addRequestParameter("date", DateFormat.getDateInstance().format(date));
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

    public void testAddEmptyLastName() {
        Date date = new Date();
        addRequestParameter("firstName", "Tanya");
        addRequestParameter("date", DateFormat.getDateInstance().format(date));
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

    public void testAddEmptyDate() {
        Date date = new Date();
        addRequestParameter("firstName", "Tanya");
        addRequestParameter("lastName", "Bogutskaya");
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

    public void testAddInvalidDate() {
        Date date = new Date();
        addRequestParameter("firstName", "Tanya");
        addRequestParameter("lastName", "Bogutskaya");
        addRequestParameter("date", "pppppp");
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

}
