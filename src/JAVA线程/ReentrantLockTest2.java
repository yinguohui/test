package JAVA线程;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentrantLockTest2 ----》解决死锁的方法--tryLock()
 * @Auhtor ygh
 * @DATE 2019/7/15 14:02
 **/
public class ReentrantLockTest2 {
    static ReentrantLock lock = new ReentrantLock();
    static ReentrantLock lock1 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo(lock,lock1));
        Thread thread1 = new Thread(new ThreadDemo(lock1,lock));
        thread.start();
        thread1.start();
        thread.interrupt();

    }
    static class ThreadDemo implements Runnable{
        ReentrantLock first;
        ReentrantLock second;
        public ThreadDemo(ReentrantLock first,ReentrantLock second){
            this.first=first;
            this.second=second;
        }

        @Override
        public void run() {
            try {
//                first.lock();
//                TimeUnit.MILLISECONDS.sleep(10);
//                second.lock();
                while(!lock.tryLock()){
                    TimeUnit.MILLISECONDS.sleep(10);
                }
                while(!lock1.tryLock()){
                    lock.unlock();
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                first.unlock();
                second.unlock();
                System.out.println(Thread.currentThread().getName()+"正常结束");
            }
        }
    }
}
