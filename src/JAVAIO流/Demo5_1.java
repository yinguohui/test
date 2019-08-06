package JAVAIO流;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo5_1 {
    static  ExecutorService service = Executors.newFixedThreadPool(1);
    public static void main(String[] args) {
        File file = new File("D:\\D_DaiMa\\TicketBook");
        File file1 = new File("D:\\D_DaiMa\\test1");
        long s = System.currentTimeMillis();
        ExecutorService service1 = Executors.newFixedThreadPool(10);
        //readfile(file,file1);
        System.out.println(System.currentTimeMillis()-s);
    }
    public static void readfile(File file,File tofile){
        String fileto = tofile.getPath();
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (int i = 0; i <files.length; i++){
                if (files[i].isDirectory()){
                    File file1 = new File(fileto+"\\"+files[i].getName());
                    file1.mkdir();
                    readfile(files[i],file1);
                }else {
                    File file1 = new File(fileto+"\\"+files[i].getName());
                    copyfile(files[i],file1);
                }
            }
        }
    }
    public static void copyfile(File file,File tofile){

        service.execute(new Thread(()->{
            FileInputStream fileInputStream = null;
            FileOutputStream fileOutputStream = null;
            try {
                byte[] bytes = new byte[1024];
                fileInputStream = new FileInputStream(file);
                fileInputStream.read(bytes);
                fileOutputStream = new FileOutputStream(tofile);
                fileOutputStream.write(bytes);
                fileInputStream.close();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }));

    }
}
