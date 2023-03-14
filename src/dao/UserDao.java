package dao;

import java.io.*;

public class UserDao {
    //被StudentService层调用
    public static boolean userLogin(String username,String password) throws IOException {
        //1.创建文件输入流
        Reader reader = new FileReader("D:\\javaCodeProjects\\MyStudentManagerData\\user.txt");
        BufferedReader br = new BufferedReader(reader);
        //从文件中读取用户名和密码
        String str;
        String uname = null;
        String psword = null;
        for (int i=0;i<2 && (str = br.readLine())!=null;i++){
            if(i==0){
                uname = str;
            }else if(i==1){
                psword = str;
            }
        }

        //3.对比用户输入的用户名密码和原先文件中存储的用户名密码是否相同
        return username.equals(uname)&&password.equals(psword);
    }
}
