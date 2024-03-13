package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

/**
 * A servlet to welcome the user.
 * @author bhesselbacher
 */

@WebServlet(
        urlPatterns = {"/trackBudget"}
)
public class TrackBudget extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Create local Servlet Context variable
        HttpSession session = req.getSession();
        ServletContext get = getServletContext();

        // Get the search type and the search term from the HTML form
        String searchType = req.getParameter("searchType");
        String searchTerm = req.getParameter("searchTerm");

        // Search for the user
        UserDao userDao = new UserDao();

        req.setAttribute("users", userDao.getAll());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
