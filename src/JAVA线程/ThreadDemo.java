package JAVA线程;

/**
 * @ClassName ThreadDemo
 * @Auhtor ygh
 * @DATE 2019/7/8 15:30
 **/
public class ThreadDemo implements Runnable {
    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag:"+flag);

    }
}
