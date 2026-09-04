package com.studentmanagement;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editStudent")
public class EditStudentServlet
        extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        int id =
                Integer.parseInt(
                        request.getParameter("id")
                );

        StudentDAO dao =
                new StudentDAO();

        Student s =
                dao.getStudentById(id);

        PrintWriter out =
                response.getWriter();

        out.println("<html>");
        out.println("<body>");

        out.println("<h2>Edit Student</h2>");

        out.println(
                "<form action='updateStudent' "
                + "method='post'>"
        );

        out.println(
                "<input type='hidden' "
                + "name='id' value='"
                + s.getId()
                + "'>"
        );

        out.println("Name:<br>");

        out.println(
                "<input type='text' "
                + "name='name' value='"
                + s.getName()
                + "'><br><br>"
        );

        out.println("Email:<br>");

        out.println(
                "<input type='email' "
                + "name='email' value='"
                + s.getEmail()
                + "'><br><br>"
        );

        out.println("Course:<br>");

        out.println(
                "<input type='text' "
                + "name='course' value='"
                + s.getCourse()
                + "'><br><br>"
        );

        out.println("Age:<br>");

        out.println(
                "<input type='number' "
                + "name='age' value='"
                + s.getAge()
                + "'><br><br>"
        );

        out.println(
                "<button type='submit'>"
                + "Update Student"
                + "</button>"
        );

        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }
}
