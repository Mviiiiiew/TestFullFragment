package com.strsoftware.strposn.util;

/**
 * Created by Wasabi on 10/5/2016.
 */

public class Util_String {
    public static String getGennerlateString(String input_value){
        return input_value.trim().replaceAll(" ","").replaceAll("'|\"","");
    }
}
