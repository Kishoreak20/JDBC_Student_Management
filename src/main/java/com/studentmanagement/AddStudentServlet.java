package com.studentmanagement;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class AddStudentServlet
        extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

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
                        name,
                        email,
                        course,
                        age
                );

        StudentDAO dao =
                new StudentDAO();

        boolean result =
                dao.addStudent(student);

        if (result) {

            response.sendRedirect(
                    "viewStudents"
            );

        } else {

            response.getWriter()
                    .println(
                            "Student Insert Failed"
                    );
        }
    }
}
