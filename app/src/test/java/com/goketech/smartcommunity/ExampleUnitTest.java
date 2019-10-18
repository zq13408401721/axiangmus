package com.goketech.smartcommunity;

import com.goketech.smartcommunity.utils.GenerateValueFile;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void createValueFile(){
        //以baseW baseH为标准的值
        int baseW = 320;
        int baseH = 480;
        String addition = GenerateValueFile.SUPPORT_DIMESION;
        new GenerateValueFile(baseW, baseH, addition).generate();

        Map<String,String> map = new HashMap<>();
        map.put("real_name","张三");
        map.put("identity","222110199011221125");

    }
}