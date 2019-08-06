package JAVA集合;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        String s1 = "dadasdada,dasdasdasdasd,dsadasdasd,dsada";
        String []ss= s1.split(",");
        String  hou ="";
        for (int i = 0; i<ss.length;i++){
            if ((i+1)%2 ==0){
                hou = hou +ss[i]+"<br>";
            }else{
                hou = hou +ss[i]+",";
            }
            System.out.println(hou);
        }
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        for (String s:list) {
            System.out.println(s);
        }
        Set<String> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        set.addAll(list);
        for (String  s: set) {
            System.out.println(s);
        }
    }
}
