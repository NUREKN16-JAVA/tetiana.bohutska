package ua.nure.kn.bohutska.usermanagement.db;

import java.util.Collection;

import ua.nure.kn.bohutska.usermanagement.User;

public interface UserDAO {

    User create(User user) throws DatabaseException;
    void update(User user) throws DatabaseException;
    void delete(User user) throws DatabaseException;
    
    User find(Long id) throws DatabaseException;
    Collection findAll() throws DatabaseException;

    public ConnectionFactory getConnectionFactory();

    public void setConnectionFactory(ConnectionFactory connectionFactory);
}
