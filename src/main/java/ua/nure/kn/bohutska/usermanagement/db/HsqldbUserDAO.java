package ua.nure.kn.bohutska.usermanagement.db;

import ua.nure.kn.bohutska.usermanagement.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;


public class HsqldbUserDAO implements UserDAO {

    private static final String INSERT_QUERY = "INSERT INTO USERS (FIRSTNAME, LASTNAME, DATEOFBIRTH) VALUES(?, ?, ?)";

    ConnectionFactory connectionFactory;
    public  HsqldbUserDAO(ConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
    }
    @Override
    public User create(User user) throws DatabaseException {
    	
        try{Connection connection = connectionFactory.createConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setDate(3, new Date(user.getDateOfBirth().getTime()));

        int n = statement.executeUpdate();
        if (n != 1) throw new DatabaseException("Numbers of Inserted rows: " + n);
        return null;
        }
        catch(DatabaseException e) {throw e;}
        catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public void update(User user) throws DatabaseException {

    }

    @Override
    public void delete(User user) throws DatabaseException {

    }

    @Override
    public User find(Long id) throws DatabaseException {
        return null;
    }

    @Override
    public Collection findAll() throws DatabaseException {
        return null;
    }
}
