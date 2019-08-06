package JAVA线程;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName LatchDemo
 * @Auhtor ygh
 * @DATE 2019/7/8 16:29
 **/
public class LatchDemo implements Runnable{
    private CountDownLatch latch;
    //有参构造函数
    public LatchDemo(CountDownLatch latch){
        this.latch = latch;
    }
    @Override
    public void run() {
        synchronized (this){
            try {
                for (int i=0;i<5000;i++) {
                    if (i%2!=0){
                        System.out.println(i);
                    }
                }
            }
            finally {
                // 线程数量递减
                latch.countDown();
            }

        }
    }
}
