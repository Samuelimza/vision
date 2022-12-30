package com.simul.vision.utils;

import java.net.URL;

public class FileUtils {

    public static URL getResourceUrl(String resourcePath) {
        try {
            return FileUtils.class.getClassLoader().getResource(resourcePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
