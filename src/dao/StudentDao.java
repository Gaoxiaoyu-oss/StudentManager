package dao;

import pojo.Student;

import java.io.*;
import java.util.ArrayList;

public class StudentDao {
    public static boolean persistStudentListToFile(ArrayList<Student> list) throws IOException {
        File dest = new File("D:\\javaCodeProjects\\MyStudentManagerData\\StudentListData.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dest)));
        for (Student student : list){
            objectOutputStream.writeObject(student);
            objectOutputStream.flush();
        }
        objectOutputStream.close();
        return true;
    }

    public static ArrayList<Student> getAllStudentsFromFile() throws IOException, ClassNotFoundException {
        File source = new File("D:\\javaCodeProjects\\MyStudentManagerData\\StudentListData.txt");
        ObjectInputStream objectOutputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(source)));
        Object o = null;
        ArrayList<Student> students = new ArrayList<>();
        while ((o = objectOutputStream.readObject())!=null){
            if( o instanceof Student){
                Student stu= (Student) o;
                students.add(stu);
            }
        }
        return students;
    }
}
