package edu.school21.javaRush.servlets;

import edu.school21.javaRush.models.User;
import edu.school21.javaRush.services.UserServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "signInServlet", value = "/signInServlet")
public class signInServlet extends HttpServlet {

    private UserServices userServices = new UserServices();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userServices.login(email, password);
        if (user != null) {
            System.out.println("User is found, redirect to Profile.jsp");
            response.sendRedirect("/profile");
        } else {
            System.out.println("It does not work!");
            response.sendRedirect("/signIn");
        }

    }
}
