package JAVA集合;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Message2
 * @Auhtor ygh
 * @DATE 2019/7/18 15:03
 **/
public class Message2 implements Delayed{
    private Integer id;
    private String messagebody;
    private long time;

    public Message2(Integer id, String messagebody, long time) {
        this.id = id;
        this.messagebody = messagebody;
        this.time = time;
    }
    public Message2(long time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessagebody() {
        return messagebody;
    }

    public void setMessagebody(String messagebody) {
        this.messagebody = messagebody;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return time-System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        Message2 message2 = (Message2) o;
        return (int) (this.time-message2.time);
    }
}
