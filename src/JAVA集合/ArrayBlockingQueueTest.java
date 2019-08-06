package JAVA集合;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ArrayBlockingQueueTest
 * @Auhtor ygh
 * @DATE 2019/7/18 16:37
 **/
public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(1);
        try {
            System.out.println(queue.offer(111));
            //System.out.println(queue.offer(111));
            //new Thread(new MyThread(queue)).start();
            //queue.put(111);
            queue.put(111);
            System.out.println();
            System.out.println(queue.poll());
            System.out.println(queue.remove());
            System.out.println(queue.take());
            System.out.println(queue.add(1111));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static class MyThread implements Runnable{
        ArrayBlockingQueue<Integer> queue;
        public MyThread(ArrayBlockingQueue<Integer> queue){
            this.queue=queue;
        }
        @Override
        public void run() {
            while (queue.size()>=1){
                queue.poll();
                System.out.println(queue.peek()+"sss");
            }
        }
    }

}
