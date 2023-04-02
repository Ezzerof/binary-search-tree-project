package com.room2.bstProject.binaryTree;

import com.room2.bstProject.App;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChildNotFoundException extends Exception{

    public ChildNotFoundException(String message) {
        super(message);
    }

}
