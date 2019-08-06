package JAVAIO流;
// 统计一个文件D:\D_DaiMa\test\calcCharNum.txt（见附件）中字母'A'和'a'出现的总次数

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        File file = new File("D:\\D_DaiMa\\test\\calcCharNum.txt");
        calcCharNum(file);
    }
    public static void calcCharNum(File file){
        int num = 0;
        //1.获取文件内容

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int n = fileInputStream.available();
            byte[] b = new byte[n];
            while(fileInputStream.read(b)!=-1){

            }
            //
            for (byte b1:b ) {
                if (b1 =='A'||b1=='a')
                    num++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }

}
