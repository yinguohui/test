package JAVAIO流;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
* 统计一个文件
*
*
* （见附件）中各个字母出现次数：
* A(8),B(16),C(10)...,a(12),b(10),c(3)....中(5),国(6)，括号内代表字符出现次数;
*/
public class Demo2 {
    public static void main(String[] args) {
        File file = new File("D:\\D_DaiMa\\test\\calcCharNum2.txt");
        calcCharNum2(file);
    }
    public  static  void  calcCharNum2(File file){
        int c;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        try {
            FileInputStream fileReader = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileReader,"gbk");
            while ((c=inputStreamReader.read())!=-1){
                char z = (char) c;
                if (null==hashMap.get(z)){
                    hashMap.put(z,1);
                }else {
                    hashMap.put(z,hashMap.get(z)+1);

                }
            }
            for (Map.Entry<Character,Integer> map: hashMap.entrySet()) {
                System.out.println("K："+map.getKey()+",V:"+map.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
