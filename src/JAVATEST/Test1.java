package JAVATEST;

import java.util.Scanner;

/**
 * @ClassName Test1
 * @Auhtor ygh
 * @DATE 2019/3/27 9:02
 **/
//​
public class Test1 {
    public static void main(String[] args) {
        int a=0,b=0;
        Scanner scanner = new Scanner(System.in);
        String col = scanner.nextLine();
        String data = scanner.nextLine();
        String[] cols = col.split(" ");
        if (cols.length!=2){
            System.out.println("Incorrect mesh size");
            return;
        }
        try {
            a = Integer.parseInt(cols[0]);
            b = Integer.parseInt(cols[1]);
        }catch (Exception e){
            System.err.println("Incorrect mesh size");
            return;
        }

        if (a<=0||b<=0){
            System.out.println("Incorrect mesh size");
            return;
        }
        if (judge(a,b,data)){
            getdata(a,b,data);
        }
    }
    //得到数据
    public static String getdata(int m,int n,String data){
        String newdata = "";
        String node = "";
        for (int i = 0; i < m; i++){
            node = data.substring(i*n,n*(i+1));
            if (i%2==1){
                node = reversedata(node);
            }
            System.out.println(node);
            newdata = newdata + node;
        }
        return  newdata;
    }
    //判断数据
    public static boolean judge(int m,int n,String data){
        if (m*n!=data.length()){
            System.out.println("Data mismatch");
            return false;
        }
        for (int i = 0; i < m*n;i++){
            if (data.charAt(i)!='R'||data.charAt(i)!='F'||data.charAt(i)!='G'){
                System.out.println("Invalid cell type");
                return false;
            }
        }
        return true;
    }
    //反转数据
    public static String reversedata(String data){
        String newdata = "";
        for (int i = data.length()-1; i >= 0;i--){
            newdata = newdata + data.charAt(i);
        }
        return  newdata;
    }
}
