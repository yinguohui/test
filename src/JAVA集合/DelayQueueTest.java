package JAVA集合;

import java.util.concurrent.*;

/**
 * @ClassName DelayQueueTest
 * @Auhtor ygh
 * @DATE 2019/7/18 14:40
 **/
public class DelayQueueTest {
    public static void main(String[] args) {
//        long now = System.currentTimeMillis();
//        // 创建延时队列
//        DelayQueue<Message2> queue = new DelayQueue<>();
//        // 添加延时消息,m1 延时3s
//        Message2 m1 = new Message2(1222,"我是消息1",3000+now);
//        // 添加延时消息,m1 延时10s
//        Message2 m2 = new Message2(2111, "hello", 10000+now);
//        //将延时消息放到延时队列中
//        queue.offer(m2);
//        queue.offer(m1);
//        Message2 message2 = queue.poll();
//        System.out.println(message2);
//        try {
//            Thread.sleep(3000);
//            Message2 message1 = queue.poll();
//            System.out.println(message1.getId()+message1.getMessagebody());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //System.out.println(queue.poll());
        //queue.poll();
       //new Thread(new Consumer(queue)).start();

        // 启动一个线程从队列中取元素
        long now = System.currentTimeMillis();
        DelayQueue<Message2> queue = new DelayQueue<>();
        new Thread(()->{
            while (true) {
                try {
                    // 将依次打印1000，2000，5000，7000，8000
                    System.out.println(queue.take().getTime() - now);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 添加5个元素到队列中
        queue.add(new Message2(now + 5000));
        queue.add(new Message2(now + 8000));
        queue.add(new Message2(now + 2000));
        queue.add(new Message2(now + 1000));
        queue.add(new Message2(now + 7000));
    }
}

