package JAVA线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestLock
 * @Auhtor ygh
 * @DATE 2019/7/8 16:41
 **/
public class TestLock{
    public static void main(String[] args){
        Ticket ticket = new Ticket();

        new Thread(ticket,"1号窗口").start();
        new Thread(ticket,"2号窗口").start();
        new Thread(ticket,"3号窗口").start();
    }
}

class Ticket implements Runnable{

    private int tick = 100;
    Lock lock = new ReentrantLock();
    public void run(){
        while(true){
            lock.lock();
            if(tick > 0){
//                try{
//                    Thread.sleep(200);
//                }catch(InterruptedException e){
//
//                }
                try {
                    System.out.println(Thread.currentThread().getName()+"完成售票,余票为: "+ --tick);
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
