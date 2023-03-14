package service;

import dao.StudentDao;
import dao.UserDao;
import pojo.Student;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService{
    @Override
    public boolean Login(String username, String password) throws IOException {
        return UserDao.userLogin(username,password);
    }

    @Override
    public boolean addStudent(Student student) {
        return false;
    }

    @Override
    public boolean deleteStudentBySno(ArrayList<Student> list, int sno) {
        //1.根据sno先找出该student
        ArrayList<Student> list1 = (ArrayList<Student>) list.stream().filter(s -> s.getSno()!=sno).collect(Collectors.toList());
        list = list1;
        return true;
    }

    @Override
    public boolean deleteStudentById(int id) {
        return false;
    }


    @Override
    public boolean updateStudentScoreBySno(ArrayList<Student> list, int sno, int score) {
        list.stream().filter(s -> s.getSno()==sno).forEach(s->{
            s.setScore(score);
        });
        return true;
    }

    @Override
    public void showAllStudents(ArrayList<Student> list) {
        list.stream().forEach(System.out::println);
    }

    @Override
    public void selectStudentBySno(ArrayList<Student> list,int sno) {
        list.stream().filter(s->s.getSno()==sno).forEach(System.out::println);
    }

    @Override
    public void selectStudentByName(ArrayList<Student> list,String name) {
        list.stream().filter(s->s.getName().contains(name)).forEach(System.out::println);
    }

    @Override
    public void showLimitStudents(ArrayList<Student> list) {
        list.stream().limit(10).forEach(System.out::println);
    }

    @Override
    public boolean persistStudentsToFile(ArrayList<Student> list) throws IOException {
        //调用dao层的方法
        return StudentDao.persistStudentListToFile(list);
    }

    @Override
    public ArrayList<Student> getAllStudentsFromFile() throws IOException, ClassNotFoundException {
        return StudentDao.getAllStudentsFromFile();
    }

    @Override
    public boolean clearAllStudents(ArrayList<Student> list) {
        list.clear();
        return true;
    }

    @Override
    public Map<String, Integer> getMax_Min_AvgScore(ArrayList<Student> list) {
        Map<String,Integer> scoreMap = new HashMap<>();
        Optional<Integer> maxScore =  list.stream().map(s ->s.getScore()).max(Integer::compare);
        scoreMap.put("最高成绩",maxScore.get());
        Optional<Integer> minScore = list.stream().map(s -> s.getScore()).min(Integer::compare);
        scoreMap.put("最低成绩",minScore.get());
        AtomicInteger sum = new AtomicInteger();
        list.stream().forEach(s -> sum.addAndGet(s.getScore()));
        int total = sum.get();
        double avg = total/ list.size();
        scoreMap.put("平均成绩", (int) avg);
        return scoreMap;
    }

    @Override
    public Map<String, Integer> getMax_Min_AvgScoreByGender(ArrayList<Student> list) {
        Optional<Integer> maxScore_MAN =list.stream().filter(s ->s.getGender().name().equals("MAN")).map(s -> s.getScore()).max(Integer::compare);
        Optional<Integer> minScore_MAN = list.stream().filter(s ->s.getGender().name().equals("MAN")).map(s -> s.getScore()).min(Integer::compare);
        AtomicInteger sum_MAN = new AtomicInteger();
        list.stream().forEach(s -> sum_MAN.addAndGet(s.getScore()));
        int total = sum_MAN.get();
        double avg_nan = total/ list.size();
        Map<String,Integer> scoreMap = new HashMap<>();
        scoreMap.put("男学生成绩最高值：",maxScore_MAN.get());
        scoreMap.put("男同学成绩最低值: ",minScore_MAN.get());
        scoreMap.put("男同学成绩平均值(取整):", (int) avg_nan);

        Optional<Integer> maxScore_Women = list.stream().filter(s->s.getGender().name().equals("WOMEN")).map(s -> s.getScore()).max(Integer::compare);
        Optional<Integer> minScore_Women = list.stream().filter(s->s.getGender().name().equals("WOMEN")).map(s -> s.getScore()).min(Integer::compare);
        AtomicInteger sum_Women = new AtomicInteger();
        list.stream().forEach(s -> sum_Women.addAndGet(s.getScore()));
        int total2 = sum_Women.get();
        double avg_nv = total2/ list.size();
        scoreMap.put("女学生成绩最高值：",maxScore_Women.get());
        scoreMap.put("女同学成绩最低值: ",minScore_Women.get());
        scoreMap.put("女同学成绩平均值(取整):", (int) avg_nv);

        return scoreMap;
    }

    @Override
    public void getMax_Min_AvgScoreBySchool(ArrayList<Student> list) {
        // key(String) 学校名: value(Double) 每个学校学生成绩平均值
        Map<String, Double> avgScoreBySchool = list.stream()
                .collect(Collectors.groupingBy(Student::getSchool, Collectors.averagingDouble(Student::getScore)));
        //key 学校名: value 每个学校成绩最高的Student
        Map<String,Student> maxScoreBySchool = list.stream()
                .collect(Collectors.toMap(Student::getSchool, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Student::getScore))));
        //key 学校名: value 每个学校成绩最低的Student
        Map<String,Student> minScoreBySchool =list.stream()
                .collect(Collectors.toMap(Student::getSchool, Function.identity(), BinaryOperator.minBy(Comparator.comparing(Student::getScore))));

        avgScoreBySchool.forEach((k,v)->{
            System.out.println("学校："+k+" 平均成绩: "+v);
        });

        maxScoreBySchool.forEach((k,v)->{
            System.out.println("学校: "+k+" 成绩最高学生信息: "+v);
        });

        minScoreBySchool.forEach((k,v)->{
            System.out.println("学校: "+k+" 成绩最低学生信息: "+v);
        });
    }

    @Override
    public void SortByScoreAndSno(ArrayList<Student> list) {
        //list.stream().sorted(Comparator.comparing(类::属性一).thenComparing(类::属性二));
        list.stream().sorted(Comparator.comparing(Student::getScore).thenComparing(Student::getSno)).forEach(System.out::println);
    }

    @Override
    public void SortBySchool_Sno(ArrayList<Student> list) {
        list.stream().sorted(Comparator.comparing(Student::getSchool).thenComparing(Student::getSno)).forEach(System.out::println);
    }

    @Override
    public void SortByGender_Score_Sno(ArrayList<Student> list) {
        list.stream().sorted(Comparator.comparing(Student::getGender).thenComparing(Student::getScore).thenComparing(Student::getSno)).forEach(System.out::println);
    }


}
