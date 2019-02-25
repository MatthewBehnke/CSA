package com.me;

import java.io.File;

public class Utils {

    public static boolean fileExist( String fileName){
        File file = new File(fileName);
        return file.exists();

    }
}
