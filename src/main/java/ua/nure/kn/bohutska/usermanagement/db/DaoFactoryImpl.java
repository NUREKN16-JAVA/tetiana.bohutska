package ua.nure.kn.bohutska.usermanagement.db;

public class DaoFactoryImpl extends DaoFactory {


    @Override
    public UserDAO getUserDAO() {
        UserDAO result = null;
        try {
            Class clasz = Class.forName(properties.getProperty("ua.nure.kn.bohutska.usermanagement.db.UserDAO"));
            result = (UserDAO) clasz.newInstance();
            result.setConnectionFactory(getConnectionFactory());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}