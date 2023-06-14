package lk.ijse.dep10.logging;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Slf4j
public class Demo1 {

    /* Loggers are named entities */
    private static final Logger log = LoggerFactory.getLogger(Demo1.class);
    private static final Logger log1 = LoggerFactory.getLogger(Demo1.class);
    private static final Logger log2 = LoggerFactory.getLogger("lk.ijse.dep10.logging.Demo1");

    public static void main(String[] args) {
        /* Log Levels
        * TRACE
        * DEBUG
        * INFO
        * WARNING
        * ERROR
        * OFF
        * */

        log.trace("This is a trace log message");
        log.debug("This is a debug log message");
        log.info("This is an info log message");
        log.warn("This is a warn log message");
        log.error("This is an error log message");

        int x = 10;
        int y = 20;
        System.out.println("x=" + x + ", y=" + y);
        log.info("x={}, y={}", x, y);
    }
}
