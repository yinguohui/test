package JAVA线程;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName Test
 * @Auhtor ygh
 * @DATE 2019/7/8 15:36
 **/
public class Test {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(10);
        LatchDemo ld = new LatchDemo(latch);

        long start = System.currentTimeMillis();

        // 创建10个线程
        for(int i=0; i<10; i++){
            new Thread(ld).start();
        }

        try{
            latch.await();
        }catch(InterruptedException e){

        }

        long end = System.currentTimeMillis();

        System.out.println("耗费时间为:"+(end - start));

    }
}
