package JAVAIO流;

import java.io.*;

/**
 * @ClassName Test
 * @Auhtor ygh
 * @DATE 2019/7/8 13:20
 **/
public class Test {
    public static void main(String[] args) throws Exception{
        Bean bean = new Bean();
        bean.setA(1);
        bean.setB(2);
        bean.setC(3);

        System.out.println("开始"+bean);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("test"));

        objectOutputStream.writeObject(bean);
        objectOutputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("test"));
        Bean bean1 = (Bean) inputStream.readObject();
        System.out.println(bean1.toString());
        inputStream.close();
    }
}
