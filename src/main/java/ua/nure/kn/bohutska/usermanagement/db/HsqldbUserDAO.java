package ua.nure.kn.bohutska.usermanagement.db;

import ua.nure.kn.bohutska.usermanagement.User;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;



public class HsqldbUserDAO implements UserDAO {

    private static final String INSERT_QUERY = "INSERT INTO USERS (FIRSTNAME, LASTNAME, DATEOFBIRTH) VALUES(?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT* FROM users";

    ConnectionFactory connectionFactory;

    public HsqldbUserDAO() {}

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
        CallableStatement callableStatement = connection.prepareCall("call IDENTITY()");
        ResultSet keys = callableStatement.executeQuery();

        if (keys.next()) {
                user.setId(keys.getLong(1));
            }
            keys.close();
            callableStatement.close();
            statement.close();
            connection.close();
            return user;
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
    public Collection<User> findAll() throws DatabaseException {
        Collection<User> result = new LinkedList<User>();

        try {
            Connection connection = connectionFactory.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);
            while(resultSet.next()) {
                User user = new User();
                user.setId(new Long(resultSet.getLong(1)));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setDateOfBirth(resultSet.getDate(4));
                result.add(user);
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }

        return result;

    }
    @Override
    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    @Override
    public void setConnectionFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
}
