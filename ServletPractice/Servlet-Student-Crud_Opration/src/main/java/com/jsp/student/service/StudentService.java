package com.jsp.student.service;

import com.jsp.student.dao.StudentDao;
import com.jsp.student.dto.Student;

public class StudentService {
	StudentDao stDao=new StudentDao();
public  Student fetchStudentByEmailForLoginService(String email) {
	return stDao.getLoginDeatilsDao(email);
}
}
