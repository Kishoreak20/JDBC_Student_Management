package com.studentmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // INSERT
    public boolean addStudent(Student student) {

        boolean status = false;

        String sql =
                "INSERT INTO students(name,email,course,age) "
                + "VALUES(?,?,?,?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setInt(4, student.getAge());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return status;
    }


    // SELECT ALL
    public List<Student> getAllStudents() {

        List<Student> list =
                new ArrayList<Student>();

        String sql =
                "SELECT * FROM students";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                Student student =
                        new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("course"));
                student.setAge(rs.getInt("age"));

                list.add(student);
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;
    }


    // SELECT BY ID
    public Student getStudentById(int id) {

        Student student = null;

        String sql =
                "SELECT * FROM students WHERE id=?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("course"));
                student.setAge(rs.getInt("age"));
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return student;
    }


    // UPDATE
    public boolean updateStudent(Student student) {

        boolean status = false;

        String sql =
                "UPDATE students "
                + "SET name=?, email=?, course=?, age=? "
                + "WHERE id=?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setInt(4, student.getAge());
            ps.setInt(5, student.getId());

            int rows =
                    ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return status;
    }


    // DELETE
    public boolean deleteStudent(int id) {

        boolean status = false;

        String sql =
                "DELETE FROM students WHERE id=?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows =
                    ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return status;
    }
}
