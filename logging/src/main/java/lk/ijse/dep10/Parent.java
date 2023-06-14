package lk.ijse.dep10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parent {

    private static final Logger log = LoggerFactory.getLogger("lk.ijse.dep10");

    public static void main(String[] args) {
        log.trace("Hello! I am from parent");
        log.debug("Hello! I am from parent");
        log.info("Hello! I am from parent");
        log.warn("Hello! I am from parent");
        log.error("Hello! I am from parent");
    }
}
