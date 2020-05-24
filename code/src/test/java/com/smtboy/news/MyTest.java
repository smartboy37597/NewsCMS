package com.smtboy.news;


import com.smtboy.news.util.Sha256;
import org.junit.jupiter.api.Test;

public class MyTest {

    @Test
    public void test1(){
        System.out.println(Sha256.getSHA256("123456"));
    }

}
