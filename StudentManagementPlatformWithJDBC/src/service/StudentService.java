package service;

import dao.StudentDAO;
import model.Student;

import java.util.List;

public class StudentService {
    private StudentDAO dao = new StudentDAO();

    public boolean addStudent(Student student) {
        return dao.addStudent(student);
    }

//    public boolean updateStudent(Student student) {
//        return dao.updateStudent(student);
//    }
//
//    public boolean deleteStudent(int id) {
//        return dao.deleteStudent(id);
//    }

    public Student getStudentById(int id) {
        return dao.getStudentById(id);
    }

//    public List<Student> getAllStudents() {
//        return dao.getAllStudents();
//    }
}
