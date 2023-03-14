package service;

import pojo.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public interface StudentService {
    //学生登录
    public boolean Login(String username,String password) throws IOException;
    //添加学生信息
    public boolean addStudent(Student student);
    //删除学生信息
    public boolean deleteStudentBySno(ArrayList<Student> list,int sno);
    public boolean deleteStudentById(int id);
    //修改学生成绩


    boolean updateStudentScoreBySno(ArrayList<Student> list, int sno, int score);

    //显示所有学生信息
    public void showAllStudents(ArrayList<Student> list);
    //根据学生学号查询学生信息
    public void selectStudentBySno(ArrayList<Student> list,int sno);
    //根据学生姓名查询学生信息(模糊查询)
    public void selectStudentByName(ArrayList<Student> list,String name);
    //查询学生信息，每次只显示10条
    public void showLimitStudents(ArrayList<Student> list);
    //将所有学生信息持久化到文件
    public boolean persistStudentsToFile(ArrayList<Student> list) throws IOException;
    //从持久文件读取所有学生信息并输出
    public ArrayList<Student> getAllStudentsFromFile() throws IOException, ClassNotFoundException;
    //将所有学生信息清空
    public boolean clearAllStudents(ArrayList<Student> list);
    //计算所有学生的最高分最低分平均分
    public Map<String, Integer> getMax_Min_AvgScore(ArrayList<Student> list);
    //分别计算男女生的最高分最低分平均分
    public Map<String,Integer> getMax_Min_AvgScoreByGender(ArrayList<Student> list);
    //分别计算每个学校的最高分最低分平均分
    public void getMax_Min_AvgScoreBySchool(ArrayList<Student> list);
    //排序-按照学生分数学号排序
    public void SortByScoreAndSno(ArrayList<Student> list);
    //排序-按照学生学校专业学号排序
    public void SortBySchool_Sno(ArrayList<Student> list);
    //排序-按照学生性别分数学号排序
    public void SortByGender_Score_Sno(ArrayList<Student> list);

}
