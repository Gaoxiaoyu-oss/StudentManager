package utils;

import pojo.Gender;
import pojo.Student;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class StudentsGenerate {
    public static ArrayList<Student> generateStudentsData() throws ParseException {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("山西大学",1,"郜晓宇",89, Gender.MAN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("南开大学",2,"孙琬",80, Gender.WOMEN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("天津理工大学",3,"张温",79, Gender.MAN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("清华大学",4,"李四",68, Gender.WOMEN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("麻省理工学院",5,"斯蒂芬库里",57, Gender.MAN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("山西大学",6,"王哥哥",40, Gender.MAN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("南开大学",7,"老王",69, Gender.MAN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("天津理工大学",8,"张哥",60, Gender.MAN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("清华大学",9,"赵鹏超",96, Gender.MAN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("麻省理工学院",10,"卡戴珊",80, Gender.WOMEN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("山西大学",11,"梦娜",70, Gender.WOMEN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("南开大学",12,"王可",50, Gender.MAN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("天津理工大学",13,"田希",97, Gender.WOMEN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("清华大学",14,"崔小红",65, Gender.WOMEN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("麻省理工学院",15,"高峰",99, Gender.MAN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("山西大学",16,"王丽",77, Gender.WOMEN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("南开大学",17,"黄宇",92, Gender.MAN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("天津理工大学",18,"倪文",89, Gender.WOMEN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("清华大学",19,"松哥",71, Gender.MAN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("麻省理工学院",20,"詹姆斯",80, Gender.MAN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        students.add(new Student("山西大学",21,"科比",100, Gender.MAN,DateUtils.getBirthDay("1998-02-02"),new Date(),null));
        return students;
    }
}
