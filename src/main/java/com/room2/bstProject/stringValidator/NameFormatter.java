package com.room2.bstProject.stringValidator;

public interface NameFormatter {
    //Formats name for input
   static String formatName(String name) {
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }

}
