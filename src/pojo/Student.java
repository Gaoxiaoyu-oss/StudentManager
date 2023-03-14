package pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Student implements Serializable {
    private static int id;//每创建一个学生对象就自动增1
    private String school;//学生所属学校
    private int sno; //学生的学号
    private String name; //学生的姓名
    private int score;// 学生成绩分数
    private Gender gender;//学生性别
    private Date birthday;//学生生日
    private Date createTime; //当前系统时间(创建的时间)
    private Date updateTime; //当前系统时间(最后一次更新信息的时间)

    public Student(){
        id ++;
    }

    public Student(String school, int sno, String name, int score, Gender gender, Date birthday, Date createTime, Date updateTime) {
        this.school = school;
        this.sno = sno;
        this.name = name;
        this.score = score;
        this.gender = gender;
        this.birthday = birthday;
        this.createTime = createTime;
        this.updateTime = updateTime;
        id ++;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Student.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sno == student.sno && score == student.score && Objects.equals(school, student.school) && Objects.equals(name, student.name) && gender == student.gender && Objects.equals(birthday, student.birthday) && Objects.equals(createTime, student.createTime) && Objects.equals(updateTime, student.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(school, sno, name, score, gender, birthday, createTime, updateTime);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id +
                ",school='" + school + '\'' +
                ", sno=" + sno +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
