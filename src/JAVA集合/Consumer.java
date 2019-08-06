package JAVA集合;

import java.util.concurrent.DelayQueue;

/**
 * @ClassName Consumer
 * @Auhtor ygh
 * @DATE 2019/7/18 15:04
 **/
public class Consumer implements Runnable{
    private DelayQueue<Message2> queue;

    public Consumer(DelayQueue<Message2> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true){
            try {
                Message2 take = queue.take();
                System.out.println("id"+take.getId()+"消息体："+take.getMessagebody());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}