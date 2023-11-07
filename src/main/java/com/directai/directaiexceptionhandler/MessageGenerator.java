package com.directai.directaiexceptionhandler;

public class MessageGenerator {
    public static String generateMessageConstructor(String propertyName){
        return propertyName + "is required in this constructor.";
    }
    private MessageGenerator(){}
}