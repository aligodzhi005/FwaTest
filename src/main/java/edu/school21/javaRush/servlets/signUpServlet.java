package edu.school21.javaRush.servlets;

import edu.school21.javaRush.config.ApplicationConfig;
import edu.school21.javaRush.models.User;
import edu.school21.javaRush.services.UserServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "signUpServlet", value = "/signUpServlet")
public class signUpServlet extends HttpServlet {
    private UserServices userServices;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<h1>HelloWorld</h1>");
        printWriter.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        userServices = context.getBean(UserServices.class);

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");


        if(userServices.createUser(firstName, lastName, email, password, phoneNumber) != null)
            response.sendRedirect("/profile");
        else
            response.sendRedirect("/signUp");
    }
}
