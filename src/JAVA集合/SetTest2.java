package JAVA集合;

import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.hash;

/**
 * @ClassName SetTest2
 * @Auhtor ygh
 * @DATE 2019/3/5 8:45
 **/
public class SetTest2 {
    public static void main(String[] args) {
        Set set = new HashSet<Integer>();
        set.add(15);
        set.add(20);
        set.add(50);
        int index = hash(15);
        System.out.println(index);

    }
}
