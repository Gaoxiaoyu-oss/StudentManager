import controller.StudentManagerContro;
import controller.UserContro;
import pojo.Gender;
import pojo.Student;
import utils.DateUtils;
import utils.StudentsGenerate;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException {
        //存储学生对象的集合
        ArrayList<Student> studentArrayList = StudentsGenerate.generateStudentsData();
        Scanner scan = new Scanner(System.in);
        int option;
        String info;
        boolean exit = false;//标识是否退出系统
        while (!exit){
            //打印欢迎页面
            WelcomePage();
            //读取用户输入选项
            option = scan.nextInt();
            switch (option){
                case 1://登录系统
                    System.out.println("请输入用户名:");
                    String username = scan.next();
                    System.out.println("请输入密码:");
                    String password = scan.next();
                    //调用controller方法
                    boolean islogin = UserContro.UserLogin(username,password);
                    if (islogin){
                        System.out.println("登录成功！");
                    }else{
                        System.out.println("用户名或密码错误，请重新登录" );
                        continue;
                    }
                    break;
                case 11://添加学生信息
                    Student student = new Student();
                    System.out.println("请输入要添加的学生的信息:");
                    System.out.println("所属学校：");
                    String school = scan.next();
                    student.setSchool(school);
                    System.out.println("学生学号：");
                    int sno = scan.nextInt();
                    student.setSno(sno);
                    System.out.println("学生姓名：");
                    String name = scan.next();
                    student.setName(name);
                    System.out.println("学生成绩分数");
                    int score = scan.nextInt();
                    student.setScore(score);
                    System.out.println("学生性别: 男 or 女");
                    String gender = scan.next();
                    if(gender.equals("男")){
                        student.setGender(Gender.MAN);
                    }else if(gender.equals("女")) {
                        student.setGender(Gender.WOMEN);
                    }
                    System.out.println("请输入学生生日,例如：1990-02-02");
                    String student_birthday = scan.next();
                    Date birthday = DateUtils.getBirthDay(student_birthday);
                    student.setBirthday(birthday);
                    student.setCreateTime(new Date());

                    studentArrayList.add(student);

                    break;
                case 12://删除学生信息
                    System.out.println("请输入要删除学生的学号：");
                    sno = scan.nextInt();
                    if(StudentManagerContro.deleteStudentBySno(studentArrayList,sno)){
                        System.out.println("删除操作成功！");
                    };
                    break;
                case 13://修改学生成绩信息
                    System.out.println("请输入要修改的学生的学号:");
                    sno = scan.nextInt();
                    System.out.println("请分别输入修改后学生成绩信息:score");
                    score = scan.nextInt();
                    if(StudentManagerContro.updateStudentScoreBySno(studentArrayList,sno,score)){
                        System.out.println("修改成功！");
                    }
                    break;
                case 14://显示所有学生成绩信息
                    StudentManagerContro.showAllStudents(studentArrayList);
                    break;
                case 21://查询学生信息-学号
                    System.out.println("请输入要查询的学生的学号：");
                    sno = scan.nextInt();
                    StudentManagerContro.selectStudentBySno(studentArrayList,sno);
                    break;
                case 22://查询学生信息-姓名(模糊)
                    System.out.println("请输入要查询的学生的姓名(可以输入姓名的一部分)");
                    name = scan.next();
                    StudentManagerContro.selectStudentByName(studentArrayList,name);
                    break;
                case 23://查询学生信息-每次只显示10条
                    StudentManagerContro.showLimitStudents(studentArrayList);
                    break;
                case 31://将所有学生信息存放到文件
                    if(StudentManagerContro.persistStudentsToFile(studentArrayList)){
                        System.out.println("所有学生信息持久化成功！");
                    }
                    break;
                case 32://将所有学生信息从文件中读回并输出
                    ArrayList<Student> stus = StudentManagerContro.getAllStudentsFromFile();
                    stus.stream().forEach(System.out::println);
                    break;
                case 33://将所有学生信息清空
                    if (StudentManagerContro.clearAllStudents(studentArrayList)){
                        System.out.println("全部学生信息清空操作完成！");
                    }
                    break;
                case 41://计算所有学生的最高分最低分平均分
                    Map<String,Integer> theMap = StudentManagerContro.getMax_Min_AvgScore(studentArrayList);
                    for( String str : theMap.keySet()){
                        System.out.println(str+" : "+theMap.get(str));
                    }
                    break;
                case 42://分别计算男女生的最高分最低分平均分
                    Map<String,Integer> scoreMap = StudentManagerContro.getMax_Min_AvgScoreByGender(studentArrayList);
                    for (String str : scoreMap.keySet()){
                        System.out.println(str+scoreMap.get(str));
                    }
                    break;
                case 43://分别计算每个学校的最高分最低分平均分
                    StudentManagerContro.getMax_Min_AvgScoreBySchool(studentArrayList);
                    break;
                case 51://排序-按照学生分数学号排序并输出
                    StudentManagerContro.SortByScoreAndSno(studentArrayList);
                    break;
                case 52://排序-按照学生学校学号排序并输出
                    StudentManagerContro.SortBySchool_Sno(studentArrayList);
                    break;
                case 53://排序-按照学生性别分数学号排序并输出
                    StudentManagerContro.SortByGender_Score_Sno(studentArrayList);
                    break;
                case -1://退出系统
                    exit = true;
                    break;
            }
        }

    }
    public static void WelcomePage(){
        System.out.println("-------------欢迎访问学生管理系统！-------------");
        System.out.println("|1.登录系统");
        System.out.println("|11.添加学生信息");
        System.out.println("|12.删除学生信息");
        System.out.println("|13.修改学生成绩信息");
        System.out.println("|14.显示所有学生信息");
        System.out.println("|21.查询学生信息-学号(精确)");
        System.out.println("|22.查询学生信息-姓名(模糊)");
        System.out.println("|23.查询学生信息-每次只显示10条");
        System.out.println("|31.将所有学生信息存放到文件");
        System.out.println("|32.将所有学生信息从文件中读回");
        System.out.println("|33.将所有学生信息清空");
        System.out.println("|41.计算所有学生的最高分最低分平均分");
        System.out.println("|42.分别计算男女生的最高分最低分平均分");
        System.out.println("|43.分别计算每个学校的最高分最低分平均分");
        System.out.println("|51.排序-按照学生分数学号排序");
        System.out.println("|52.排序-按照学生学校专业学号排序");
        System.out.println("|53.排序-按照学生性别分数学号排序");
        System.out.println("|99.随机生成1000条模拟数据");
        System.out.println("|-1.退出系统");
        System.out.println("------------(请输入要执行的菜单编号)-----------");
    }
}