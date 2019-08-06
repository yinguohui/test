package JAVA集合;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName Queue
 * @Auhtor ygh
 * @DATE 2019/7/17 14:10
 **/
public class QueueTest {
    private int count = 10;
    private ArrayBlockingQueue queue = new ArrayBlockingQueue(count);
    public static void main(String[] args) throws InterruptedException {
        QueueTest queueTest = new QueueTest();
        QueueThreadPut queueThreadPut = queueTest.new QueueThreadPut();
        QueueThreadTake queueThreadTake = queueTest.new QueueThreadTake();
        queueTest.queue.put(1);
        queueTest.queue.put(2);
        queueThreadPut.run();
        queueThreadTake.run();

    }

    class QueueThreadTake implements Runnable{
        @Override
        public void run() {
            for (;;){
                try {
                    System.out.println(queue.take());
                    System.out.println("队列移除一个元素："+"队列空间："+queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    class QueueThreadPut implements Runnable{
        @Override
        public void run() {
            for (;;){
                try {
                    queue.put(1);
                    System.out.println("队列加入一个元素："+"队列空间："+queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
