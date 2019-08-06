package JAVAIO流;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

//（十） 使用随机文件流类randomAccessFile将一个文本D:\D_DaiMa\test\calcCharNum2.txt文件倒置读出
public class Demo3 {

    public static void main(String[] args) {
        File file = new File("D:\\D_DaiMa\\test\\calcCharNum2.txt");
        randomAccessFile(file);
    }

    public static  void  randomAccessFile(File file){
        try {
            RandomAccessFile randomAccessFile =  new RandomAccessFile(file, "r");
            Long n= randomAccessFile.length();
            randomAccessFile.seek(n);
            StringBuffer sb = new StringBuffer();
            int s;
            while (n>0){
                n--;
                randomAccessFile.seek(n);
                s = (char) randomAccessFile.readByte();
                // 如果asc码<=255,>=0,则判断是个英文字符,添加到字符串中.
                if (s >= 0 && s <= 255) {
                    sb.append((char) s);
                } else {
                    // 如果不在asc码范围内,则判断是个汉字字符
                    // 汉字字符是占2个字节的,所以length再退一个字节
                    n--;
                    randomAccessFile.seek(n);
                    byte[] cc = new byte[2];
                    // cc被复制为文件中连续的两个字节
                    randomAccessFile.readFully(cc);
                    sb.append(new String(cc,"GBK"));
                }

            }
            System.out.println(sb);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
}
