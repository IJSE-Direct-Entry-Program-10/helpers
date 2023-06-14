package lk.ijse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuperParent {

    private static final Logger log = LoggerFactory.getLogger("lk.ijse");
    private static final Logger log2 = LoggerFactory.getLogger("lk.ijse.dep10");

    public static void main(String[] args) {
        log.trace("Hello! I am from super parent");
        log.debug("Hello! I am from super parent");
        log.info("Hello! I am from super parent");
        log.warn("Hello! I am from super parent");
        log.error("Hello! I am from super parent");
        log2.info("Hello I am from super parent");
    }
}
