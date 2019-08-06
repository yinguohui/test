package JAVAIO流;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @ClassName Bean
 * @Auhtor ygh
 * @DATE 2019/7/8 13:17
 **/
public class Bean implements Serializable{

    private static final long serialVersionUID = 1710022455003682613L;
    private int a;
    private int b;
    private int d;
    private transient int c;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }


    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "a=" + a +
                ", b=" + b +
                ", d=" + d +
                ", c=" + c +
                '}';
    }
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(this.c);
    }
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.c = (int) stream.readObject();
    }
}
