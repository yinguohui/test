package JAVA集合;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName LinkedBlockingQueueTset
 * @Auhtor ygh
 * @DATE 2019/7/17 16:57
 **/
public class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        LinkedBlockingQueue queue = new LinkedBlockingQueue(2);
        new Thread(new MyThread(queue)).start();
        new Thread(new MyThread1(queue)).start();
    }
    static  class MyThread implements Runnable{
        LinkedBlockingQueue queue;
        public MyThread(LinkedBlockingQueue queue){
            this.queue =queue;
        }
        @Override
        public void run() {
            while (true){
                System.out.println("出去");
                if (queue.size()>=2){
                    System.out.println("满了");
                    queue.poll();
                }
            }
        }
    }
    static  class MyThread1 implements Runnable{
        LinkedBlockingQueue queue;
        public MyThread1(LinkedBlockingQueue queue){
            this.queue =queue;
        }
        @Override
        public void run() {
            for (;;){
                try {
                    System.out.println("进入");
                    queue.put(111);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
