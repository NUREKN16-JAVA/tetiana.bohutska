package ua.nure.kn.bohutska.usermanagement.web;
import ua.nure.kn.bohutska.usermanagement.User;
import ua.nure.kn.bohutska.usermanagement.db.DaoFactory;
import ua.nure.kn.bohutska.usermanagement.db.DatabaseException;
import ua.nure.kn.bohutska.usermanagement.db.UserDAO;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class BrowseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            browse(req, resp);


    }



    private void browse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<User> users;
        try {
            users = DaoFactory.getInstance().getUserDAO().findAll();
            req.getSession().setAttribute("users", users);
            req.getRequestDispatcher("/browse.jsp").forward(req, resp);
        } catch (DatabaseException e) {
            throw new ServletException(e);
        }

    }

}