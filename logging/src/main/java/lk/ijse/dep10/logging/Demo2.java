package lk.ijse.dep10.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo2 {

    private static final Logger log = LoggerFactory.getLogger(Demo2.class);

    public static void main(String[] args) {
        log.trace("I am from Demo2");
        log.debug("I am from Demo2");
        log.info("I am from Demo2");
        log.warn("I am from Demo2");
        log.error("I am from Demo2");
    }
}
