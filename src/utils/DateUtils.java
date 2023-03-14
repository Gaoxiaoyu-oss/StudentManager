package utils;

import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    @Test
    public void testDate() throws ParseException {
//        Date mydate1 = new Date();
//        System.out.println(mydate1);

        Date myDate2 =new Date();
        //字符串的形式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //转字符串
        String dateStr =dateFormat.format(myDate2);
        System.out.println(dateStr);//2022-09-25 17:58:02
        //转成日期
        Date myDate = dateFormat.parse("2020-02-25 11:16:30"); //这里有异常
        //System.out.println(myDate.getTime());
        System.out.println(myDate);//Tue Feb 25 11:16:30 CST 2020
    }

    public static Date getBirthDay(String birthday) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(birthday);
    }
}
