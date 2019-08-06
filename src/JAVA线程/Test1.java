package JAVA线程;

/**
 * @ClassName Test1
 * @Auhtor ygh
 * @DATE 2019/7/3 15:05
 **/
public class Test1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
               for (int i = 0;i<10;i++){
                   System.out.println("thread1"+i);
                   try {
                       sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        };
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            for (int i = 0;i<10;i++){
                System.out.println(i);
            }
        }).start();
    }
}
