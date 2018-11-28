package ua.nure.kn.bohutska.usermanagement.db;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ua.nure.kn.bohutska.usermanagement.User;

import java.util.Date;

public class HsqldbUserDAOTest {

   HsqldbUserDAO dao;
   User user;
   ConnectionFactory connectionFactory;

	@Before
	public void setUp() throws Exception {

	    connectionFactory = new ConnectionFactoryImpl("org.hsqldb.jdbcDriver", "jdbc:hsqldb:file:db/usermanagement", "sa", "");
		dao = new HsqldbUserDAO(connectionFactory);
		user = new User("Tanya","Bogutskaya",new Date());
	}

	@Test
	public void testCreate()  {
        try {
            assertNull(user.getId());
            user = dao.create(user);
            assertNotNull(user);
            assertNotNull(user.getId());
        } catch (DatabaseException e) {
            e.printStackTrace();
            fail(e.toString());
        }

    }


}