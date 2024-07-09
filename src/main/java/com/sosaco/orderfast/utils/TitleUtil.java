package com.sosaco.orderfast.utils;

public class TitleUtil {

    public static String getInitials (String title){
        StringBuilder initials = new StringBuilder();
        String[] words = title.split("\\s");
        for (int i = 0; i < words.length; i++){
            if (i == 10) break;
            if (!words[i].isEmpty()) initials.append(words[i].charAt(0));
        }
        return initials.toString().toUpperCase();
    }
}

