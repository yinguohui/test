package Spring.SpringAop;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @ClassName AopTest1
 * @Auhtor ygh
 * @DATE 2019/7/4 13:49
 **/
public class TestLogger {
    public static void main(String[] args) {
        Logger log = Logger.getLogger("lavasoft");
        log.setLevel(Level.INFO);
        Logger log1 = Logger.getLogger("lavasoft");
        System.out.println(log==log1);     //true
        Logger log2 = Logger.getLogger("lavasoft.blog");
        log2.setLevel(Level.INFO);

        log.info("aaa");
        log2.info("bbb");
        log2.info("fine");
    }
}
