package com.syw.showmeshopsyw;

import com.syw.showmeshopsyw.util.QQMailUtil;
import com.syw.showmeshopsyw.util.QRCodeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShowmeshopSywApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1()throws Exception{
        QRCodeUtil.zxingCodeCreate("2555","D:/uploads/",
                250,"D:/uploads/zhi.jpg");
    }
   /* @Test
    public void test2()throws Exception{
        QQMailUtil.QQmail();
    }*/

}
