package com.jsp.servlet_simple_opreration.service;

import com.jsp.servlet_simple_opreration.dao.StudentDao;
import com.jsp.servlet_simple_opreration.dto.Student;

public class StudentService {

    StudentDao dao = new StudentDao();

    public Student saveStudentService(Student student) {
        return dao.insertRecord(student);
    }

    public Student fetchStudentByEmailForLoginService(String userEmail) {
        return dao.fetchStudentemailForLoginDao(userEmail);
    }
}
