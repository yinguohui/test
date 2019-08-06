package JAVA集合;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ListTest
 * @Auhtor ygh
 * @DATE 2019/3/4 11:18
 **/
public class ListTest {

    List list = new ArrayList(10);

    public static void main(String[] args) {
        ListTest listTest = new ListTest();
        listTest.list.add(1);
        listTest.list.add(2);
        listTest.list.add(null);
        listTest.list.add(3);
        int i =listTest.list.indexOf(null);
        System.out.println(i);

    }
}
