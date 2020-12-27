package cn.edu.swjtu.utils;

import org.junit.Test;

public class TestDBUtil {

    @Test
    public void test(){
        DBUtil dbUtil = new DBUtil();
        dbUtil.initializeDB();
        boolean result = dbUtil.executeQuery("Alice","aaaaaaaaaa");
        System.out.println(result);
    }

}
