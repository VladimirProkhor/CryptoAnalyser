package com.javarush.prokhorov.util;

import java.io.File;

public class PathFinder {
    public PathFinder() {
    }

    public String getRoot() {
        String root = System.getProperty("user.dir");
        return root + File.separator + "text" +File.separator;
    }
}
