package JAVA线程;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @ClassName ThreadPoolTest
 * @Auhtor ygh
 * @DATE 2019/7/8 16:58
 **/
public class ThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        for (int i = 0;i<100;i++){
            Future<Integer> re = service.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName()+":"+num);
                    return num;
                }
            },3, TimeUnit.SECONDS);
        }
        service.shutdown();
    }
}
