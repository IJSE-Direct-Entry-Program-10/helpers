package lk.ijse.dep10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParentDemo {

    private static final Logger log = LoggerFactory.getLogger(ParentDemo.class);

    public static void main(String[] args) {
        log.trace("Hello! I am from parent demo");
        log.debug("Hello! I am from parent demo");
        log.info("Hello! I am from parent demo");
        log.warn("Hello! I am from parent demo");
        log.error("Hello! I am from parent demo");
    }
}
