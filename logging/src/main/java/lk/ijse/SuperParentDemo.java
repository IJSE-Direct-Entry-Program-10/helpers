package lk.ijse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuperParentDemo {

    private static final Logger log = LoggerFactory.getLogger(SuperParentDemo.class);

    public static void main(String[] args) throws InterruptedException {
        log.trace("Hello! I am from super parent demo");
        log.debug("Hello! I am from super parent demo");
        log.info("Hello! I am from super parent demo");
        log.warn("Hello! I am from super parent demo");
        log.error("Hello! I am from super parent demo");

        Thread.sleep(2500);
    }
}
