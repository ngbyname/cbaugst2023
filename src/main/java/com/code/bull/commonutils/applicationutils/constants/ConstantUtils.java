package com.code.bull.commonutils.applicationutils.constants;

import java.util.Properties;

public class ConstantUtils {

    private static ConstantUtils constants;
    private static final Properties props = null;

    public static ConstantUtils getInstance() {
        if (constants == null) {
            constants = new ConstantUtils();
        }
        return constants;
    }

    public String getValue(String key) {
        return props.getProperty(key);
    }
}
