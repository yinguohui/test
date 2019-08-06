package JVM;

import javax.naming.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @ClassName Demo1
 * @Auhtor ygh
 * @DATE 2019/2/21 11:38
 **/
public class Demo1 {
    public static void main(String[] args) {
        String aa = "11";
        ReferenceQueue<String> reference = new ReferenceQueue<String>();
        WeakReference<String> a = new WeakReference(aa,reference);
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(reference);
    }
}
