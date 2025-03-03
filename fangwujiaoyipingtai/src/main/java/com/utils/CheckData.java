package com.utils;


import org.apache.poi.ss.formula.functions.T;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 验证数据
 */
public class CheckData {


    public static void checkMap(Map<String,Object> map){

        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Object> entry=it.next();
            Object o = entry.getValue();
            if(o instanceof String){
                String o1 = (String) o;
                if("".equals(o1) || "null".equals(o1)|| o1 ==null){
                    it.remove();
                }
            }
        }
    }
}
