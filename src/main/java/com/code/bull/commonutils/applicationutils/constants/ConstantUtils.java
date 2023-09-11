package com.code.bull.commonutils.applicationutils.constants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import static com.code.bull.driver.Driver.commonLib;
import static com.code.bull.driver.Driver.env;

public class ConstantUtils {

    private static ConstantUtils constants;
    private static Properties props = null;
    private static final String ENV_FILE_PATH = System.getProperty("user.dir");
    private static final String PROPERTIES_FILE_PATH = ENV_FILE_PATH + "/src/main/resources/properties/";
    private static final String PROPERTIES_ENV_PATH = PROPERTIES_FILE_PATH + env + ".properties";
    private static final String COMMON_PROPERTIES_PATH = PROPERTIES_FILE_PATH + "common.properties";
    private static final String MESSAGE_PROPERTIES_PATH = PROPERTIES_FILE_PATH + "message.properties";

    private static final List<String> fileList = Arrays.asList(PROPERTIES_ENV_PATH, COMMON_PROPERTIES_PATH, MESSAGE_PROPERTIES_PATH);

    private ConstantUtils() {
        props = new Properties();
        fileList.forEach(file -> {
            Scanner inFile;
            try {
                inFile = new Scanner(new FileReader(file));
                inFile.next();
            } catch (FileNotFoundException e) {
                commonLib.error(e.getMessage());
            }
            try {
                InputStream input = Files.newInputStream(Paths.get(file));
                props.load(input);
            } catch (IOException e) {
                commonLib.error(e.getMessage());
            }
        });
    }

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
