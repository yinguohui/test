package JAVAIO流;

import java.io.*;
import java.util.Scanner;

/**
 * （十一） 编写一个Java应用程序，可以实现Dos中的type命令，并加上行号。
 即将文本文件在控制台上显示出来，并在每一行的前面加上行号。
 */
public class Demo4 {
    public static void main(String[] args) throws Exception {
        printline(new File("D:\\D_DaiMa\\test\\calcCharNum2.txt"));
    }
    public static void printline(File file) throws Exception {
        System.out.println("请输入命令---");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"GBK");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        Scanner scanner = new Scanner(System.in);
        String config = scanner.nextLine();
        String[] s = config.split(" ");
        if (s[0].equals("type")&&s.length==2){
            int n = Integer.parseInt(s[1]);
            String line = "";
            int reline = 0;
            while ((line=bufferedReader.readLine())!=null){
                if (++reline>n){
                    break;
                }
                System.out.println(reline+":"+line);
            }
            if (reline<n){
                for (int i = reline+1; i <= n; i++){
                    System.out.println(i+":"+"暂无数据");
                }
            }

        }
        else{
            System.out.println("命令不正确");
        }
    }

}
