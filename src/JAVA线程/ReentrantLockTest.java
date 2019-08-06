package JAVA线程;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentrantLockTest
 * @Auhtor ygh
 * @DATE 2019/7/15 11:34
 **/
public class ReentrantLockTest {
    static Lock lock = new ReentrantLock(true);
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        for (int i=0;i<50;i++){
            new Thread(new ThreadDemo(i)).start();
        }
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    static class ThreadDemo implements Runnable{
        Integer id;
        public ThreadDemo(Integer id){
            this.id = id;

        }
        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i=0;i<2;i++){
                lock.lock();
                System.out.println("获取所得线程"+id);
                lock.unlock();
            }
        }
    }
}
