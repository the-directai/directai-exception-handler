package com.directai.directaiexceptionhandler;

import com.directai.directaiexceptionhandler.exception.DirectExceptionFrame;

public class DirectServerExceptionCode {
    public static final DirectExceptionFrame D4000 =
            new DirectExceptionFrame("D4000", "Bad request");
    public static final DirectExceptionFrame D4001 =
            new DirectExceptionFrame("D4001", "Validation error");
    public static final DirectExceptionFrame D4002 =
            new DirectExceptionFrame("D4002", "Multiple error");

    private DirectServerExceptionCode() {
    }
}
