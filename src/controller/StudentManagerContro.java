package controller;

import pojo.Student;
import service.StudentService;
import service.StudentServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class StudentManagerContro {
    static StudentService studentService = null;
    public static boolean deleteStudentBySno(ArrayList<Student> list, int sno){
        studentService = new StudentServiceImpl();
        return studentService.deleteStudentBySno(list,sno);
    }

    public static boolean updateStudentScoreBySno(ArrayList<Student> list,int sno,int score){
        studentService = new StudentServiceImpl();
        return studentService.updateStudentScoreBySno(list,sno,score);
    }

    public static void showAllStudents(ArrayList<Student> list){
        studentService = new StudentServiceImpl();
        studentService.showAllStudents(list);
    }

    public static void selectStudentBySno(ArrayList<Student> list,int sno){
        studentService = new StudentServiceImpl();
        studentService.selectStudentBySno(list,sno);
    }

    public static void selectStudentByName(ArrayList<Student> list,String name){
        studentService = new StudentServiceImpl();
        studentService.selectStudentByName(list,name);
    }

    public static void  showLimitStudents(ArrayList<Student> list){
        studentService = new StudentServiceImpl();
        studentService.showLimitStudents(list);
    }

    public static boolean persistStudentsToFile(ArrayList<Student> list) throws IOException {
        studentService = new StudentServiceImpl();
        return studentService.persistStudentsToFile(list);
    }

    public static ArrayList<Student> getAllStudentsFromFile() throws IOException, ClassNotFoundException {
        studentService = new StudentServiceImpl();
        return studentService.getAllStudentsFromFile();
    }

    public static boolean clearAllStudents(ArrayList<Student> list){
        studentService = new StudentServiceImpl();
        return studentService.clearAllStudents(list);
    }

    public static  Map<String, Integer> getMax_Min_AvgScore(ArrayList<Student> list){
        studentService = new StudentServiceImpl();
        return studentService.getMax_Min_AvgScore(list);
    }

    public static Map<String, Integer> getMax_Min_AvgScoreByGender(ArrayList<Student> list){
        studentService = new StudentServiceImpl();
        return studentService.getMax_Min_AvgScoreByGender(list);
    }

    public static void getMax_Min_AvgScoreBySchool(ArrayList<Student> list){
        studentService = new StudentServiceImpl();
        studentService.getMax_Min_AvgScoreBySchool(list);
    }

    public static void SortByScoreAndSno(ArrayList<Student> list){
        studentService = new StudentServiceImpl();
        studentService.SortByScoreAndSno(list);
    }

    public static void SortByGender_Score_Sno(ArrayList<Student> list){
        studentService = new StudentServiceImpl();
        studentService.SortByGender_Score_Sno(list);
    }

    public static void SortBySchool_Sno(ArrayList<Student> list) {
        studentService = new StudentServiceImpl();
        studentService.SortBySchool_Sno(list);
    }
}
