import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

/**
 * @author yangyang
 * @date 2021/7/1-10:56
 **/
public class T1 {
    /**
     * 获取当前时区的时间
     * @author yangyang
     * @date 2021/7/1 10:57
     */
    @Test
    public void test() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
