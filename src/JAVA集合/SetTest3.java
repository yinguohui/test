package JAVA集合;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName SetTest3
 * @Auhtor ygh
 * @DATE 2019/3/5 9:00
 **/
public class SetTest3 {

    public static void main(String[] args) {
        Person person = new Person(12);
        Person person1 = new Person(13);
        Person person2 = new Person(12);
        Person person3 = new Person(16);
        Person person4 = new Person(18);
        Set set = new TreeSet<>(new Person());
        set.add(person);
        set.add(person1);
        set.add(person2);
        set.add(person3);
        set.add(person4);
        System.out.println(set);
    }

}
class Person implements Comparator<Person> {

    private int age;
    public  Person(){

    }

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return o1.age-o2.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }


}
