package com.studentmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewStudents")
public class ViewStudentsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        StudentDAO dao = new StudentDAO();

        List<Student> students = dao.getAllStudents();

        out.println("<!DOCTYPE html>");
        out.println("<html>");

        out.println("<head>");
        out.println("<meta charset='UTF-8'>");

        out.println("<meta name='viewport' "
                + "content='width=device-width, initial-scale=1.0'>");

        out.println("<title>View Students</title>");

        out.println("<link rel='stylesheet' href='style.css'>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='container'>");

        out.println("<div class='table-card'>");

        out.println("<div class='table-header'>");

        out.println("<h2>Student Details</h2>");

        out.println("<a href='addStudent.html' "
                + "class='btn btn-primary'>"
                + "+ Add Student"
                + "</a>");

        out.println("</div>");

        if (students.isEmpty()) {

            out.println("<div class='empty-message'>");
            out.println("No Students Found");
            out.println("</div>");

        } else {

            out.println("<div class='table-container'>");

            out.println("<table class='student-table'>");

            out.println("<thead>");

            out.println("<tr>");

            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Email</th>");
            out.println("<th>Course</th>");
            out.println("<th>Age</th>");
            out.println("<th>Actions</th>");

            out.println("</tr>");

            out.println("</thead>");

            out.println("<tbody>");

            for (Student student : students) {

                out.println("<tr>");

                out.println("<td>"
                        + student.getId()
                        + "</td>");

                out.println("<td>"
                        + student.getName()
                        + "</td>");

                out.println("<td>"
                        + student.getEmail()
                        + "</td>");

                out.println("<td>"
                        + student.getCourse()
                        + "</td>");

                out.println("<td>"
                        + student.getAge()
                        + "</td>");

                out.println("<td>");

                out.println("<div class='action-buttons'>");

                out.println("<a href='editStudent?id="
                        + student.getId()
                        + "' class='btn btn-warning'>"
                        + "Edit"
                        + "</a>");

                out.println("<a href='deleteStudent?id="
                        + student.getId()
                        + "' class='btn btn-danger' "
                        + "onclick=\"return confirm('Are you sure you want to delete this student?')\">"
                        + "Delete"
                        + "</a>");

                out.println("</div>");

                out.println("</td>");

                out.println("</tr>");
            }

            out.println("</tbody>");

            out.println("</table>");

            out.println("</div>");
        }

        out.println("<div class='bottom-button'>");

        out.println("<a href='index.html' "
                + "class='btn btn-secondary'>"
                + "Back to Home"
                + "</a>");

        out.println("</div>");

        out.println("</div>");

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");
    }
}