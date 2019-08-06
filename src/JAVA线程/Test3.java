package JAVA线程;

/**
 * @ClassName Test3
 * @Auhtor ygh
 * @DATE 2019/7/3 17:06
 **/
public class Test3 {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while(!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }
    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ready = true;
    }
}
