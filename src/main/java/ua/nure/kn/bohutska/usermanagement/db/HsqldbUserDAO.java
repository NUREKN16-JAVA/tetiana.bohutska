package ua.nure.kn.bohutska.usermanagement.db;

import ua.nure.kn.bohutska.usermanagement.User;

import java.util.Collection;

public class HsqldbUserDAO implements UserDAO {

    ConnectionFactory connectionFactory;
    public  HsqldbUserDAO(ConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
    }
    @Override
    public User create(User user) throws DatabaseException {
        return null;
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
