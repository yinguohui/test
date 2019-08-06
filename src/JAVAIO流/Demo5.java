package JAVAIO流;

import java.io.*;
import java.util.Scanner;

//输入两个文件夹名称，将A文件夹内容全部拷贝到B文件夹，要求使用多线程来操作。
public class Demo5 {
    public static void main(String[] args)throws Exception {
       // File file = new File("D:\\D_DaiMa\\test\\calcCharNum2.txt");
        //File file1 = new File("D:\\D_DaiMa\\test\\calcCharNum.txt");
        //System.out.println(filetofile(file,file1));
        // char[] chars = new char[1024];
       // BufferedReader bufferedReader = new BufferedReader(new FileReader(""));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(""));
       /* new Thread(() -> {
            try {
                synchronized (Demo5.class){
                    while (bufferedReader.read(chars)!=-1){

                    }
                }
            }
            catch (Exception e){

            }


        });
        new Thread(() -> {
            try {
                synchronized (Demo5.class){
                    bufferedWriter.write(chars);
                    bufferedWriter.flush();
                }
            }catch (Exception e){

            }
        });*/
       // D:\\D_DaiMa\\test D:\\D_DaiMa
        copyto();
    }
    public static  void  copyto(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个文件夹的地址：请用空格分隔");
        String path= scanner.nextLine();
        String[] paths = path.split(" ");
        if (paths.length==2){
            File fromfile = new File(paths[0]);
            File tofile = new File(paths[1]);
            if (fromfile.exists()&&tofile.exists()) {
                getfiles(fromfile,tofile);
            }else {
                System.out.println("文件夹输入不正确");
            }
        }
        else {
            System.out.println(paths.length);
            System.out.println("格式或数据输入错误");
        }

    }
    public  static  void  getfiles(File file,File tofile){
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File file1:files) {
                if (file1.isDirectory()){
                    getfiles(file1,tofile);
                }
                else {
                    try {
                        new Thread(() -> {
                            try {
                                synchronized (Demo5.class){
                                    byte[] bs=input(file1.getAbsolutePath());
                                   out(new File(filetofile(file1,tofile)),bs);
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }).start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
    public static String filetofile(File file,File file2){
        String s = file.getAbsolutePath();
        String s1 = file2.getAbsolutePath();
        int n = s.length()<s1.length()?s.length():s1.length();
        String newStr = "";
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i)!=s.charAt(i)||i==n-1){
                newStr =s.substring(0,i)+s1.substring(i);
                System.out.println(newStr);
                break;
            }
        }
        return newStr.replace("\\","\\"+"\\");
    }
    //获取输入流
    public static byte[] input(String path) throws IOException{
        File file = new File(path);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            int n;
            n = fileInputStream.available();
            byte[] bs = new byte[n];
            while(fileInputStream.read(bs)!=-1) {

            }
            return bs;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            return null;
        }finally {
            fileInputStream.close();
        }
    }
    public static void out(File file, byte[] bs) throws IOException {
        FileOutputStream outputStream = null;
        try {
            outputStream= new FileOutputStream(file);
            outputStream.write(bs);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            outputStream.close();
        }




    }
}
