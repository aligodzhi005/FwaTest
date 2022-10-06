package edu.school21.javaRush.servlets;

import edu.school21.javaRush.config.ApplicationConfig;
import edu.school21.javaRush.models.User;
import edu.school21.javaRush.services.UserServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "signInServlet", value = "/signInServlet")
public class signInServlet extends HttpServlet {

    private UserServices userServices;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        userServices = context.getBean(UserServices.class);

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
