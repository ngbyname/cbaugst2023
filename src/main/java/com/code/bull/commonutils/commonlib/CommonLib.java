package com.code.bull.commonutils.commonlib;

import com.code.bull.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

public class CommonLib extends Driver {

    public static final Logger log = LogManager.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    /**
     * This method is used to print the info msg
     *
     * @param msg the info msg
     */
    public void info(String msg) {
        log.info(msg);
    }

    /**
     * This method is used to print the error msg
     *
     * @param msg the error msg
     */
    public static void error(String msg) {
        log.error(msg);
    }

    /**
     * This method is used to print the warning msg
     *
     * @param msg the warning msg
     */
    public void warning(String msg) {
        log.warn(msg);
    }

    /**
     * This method is used to print the fail msg
     *
     * @param msg the fail msg
     */
    public void fail(String msg) {
        log.error(msg);
    }

    /**
     * This method is used to print the pass msg
     *
     * @param msg the pass msg
     */
    public static void pass(String msg) {
        log.info(msg);
    }
}
