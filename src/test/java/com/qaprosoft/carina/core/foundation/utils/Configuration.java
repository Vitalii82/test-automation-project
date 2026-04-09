package com.qaprosoft.carina.core.foundation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private static final Properties props = new Properties();

    static {
        try (InputStream is = Configuration.class.getClassLoader()
                .getResourceAsStream("_config.properties")) {
            if (is != null) props.load(is);
        } catch (IOException e) {
            // ignore
        }
    }

    public static String getRequired(String key) {
        String value = System.getProperty(key, props.getProperty(key));
        if (value == null || value.isBlank()) {
            throw new RuntimeException("Required config key not found: " + key);
        }
        return value;
    }

    public static String get(String key, String defaultValue) {
        return System.getProperty(key, props.getProperty(key, defaultValue));
    }
}
