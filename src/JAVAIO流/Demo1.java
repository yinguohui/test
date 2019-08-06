package JAVAIO流;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
  统计一个文件D:\D_DaiMa\test\calcCharNum.txt（见附件）中各个字母出现次数：
  A(8),B(16),C(10)...,a(12),b(10),c(3)....，括号内代表字符出现次数
 */
public class Demo1 {
    public static void main(String[] args) {
        File file = new File("D:\\D_DaiMa\\test\\calcCharNum.txt");
        calcCharNum(file);
    }
    public static void calcCharNum(File file){
        //1.获取文件内容
        int len = 0;
        HashMap<String,Integer> map = new HashMap();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            while((len=fileInputStream.read())!=-1){
                char c = (char) len;
               if (null==map.get(c+"")){
                   map.put(c+"",1);
               }else {
                   map.put(c+"",map.get(c+"")+1);
               }
            }
            //遍历计算
            for (Map.Entry<String,Integer> b1: map.entrySet() ){
                System.out.println("K："+b1.getKey()+",V:"+b1.getValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
