package dao;

import model.Student;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students(name, email, course) VALUES (?, ?, ?)";
        try {
        	Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//    public boolean updateStudent(Student student) {
//        String sql = "UPDATE students SET name=?, email=?, course=? WHERE id=?";
//        try (Connection con = DBConnection.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setString(1, student.getName());
//            ps.setString(2, student.getEmail());
//            ps.setString(3, student.getCourse());
//            ps.setInt(4, student.getId());
//            return ps.executeUpdate() > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean deleteStudent(int id) {
//        String sql = "DELETE FROM students WHERE id=?";
//        try (Connection con = DBConnection.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setInt(1, id);
//            return ps.executeUpdate() > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("course")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//
//    public List<Student> getAllStudents() {
//        List<Student> list = new ArrayList<>();
//        String sql = "SELECT * FROM students";
//        try (Connection con = DBConnection.getConnection();
//             Statement st = con.createStatement();
//             ResultSet rs = st.executeQuery(sql)) {
//            while (rs.next()) {
//                list.add(new Student(
//                    rs.getInt("id"),
//                    rs.getString("name"),
//                    rs.getString("email"),
//                    rs.getString("course")
//                ));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
}
