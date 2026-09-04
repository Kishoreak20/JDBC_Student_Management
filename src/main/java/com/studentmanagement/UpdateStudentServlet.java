package com.studentmanagement;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateStudent")
public class UpdateStudentServlet
        extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id =
                Integer.parseInt(
                        request.getParameter("id")
                );

        String name =
                request.getParameter("name");

        String email =
                request.getParameter("email");

        String course =
                request.getParameter("course");

        int age =
                Integer.parseInt(
                        request.getParameter("age")
                );

        Student student =
                new Student(
                        id,
                        name,
                        email,
                        course,
                        age
                );

        StudentDAO dao =
                new StudentDAO();

        dao.updateStudent(student);

        response.sendRedirect(
                "viewStudents"
        );
    }
}
