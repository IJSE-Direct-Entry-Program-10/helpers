package lk.ijse.dep10.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {

    private static final Logger log = LoggerFactory.getLogger(Logging.class);

    public static void main(String[] args) {
        log.trace("I am from logging!");
        log.debug("I am from logging!");
        log.info("I am from logging!");
        log.warn("I am from logging!");
        log.error("I am from logging!");
    }
}
