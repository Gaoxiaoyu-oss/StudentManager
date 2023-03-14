package controller;

import service.StudentService;
import service.StudentServiceImpl;

import java.io.IOException;

public class UserContro {

     static    StudentService studentService = null;


    public static boolean UserLogin(String username,String password) throws IOException {
        studentService = new StudentServiceImpl();
        return studentService.Login(username,password);
    }
}
