package com.feb.multifragment.struct;

/**
 * Created by lilichun on 2019/2/21.
 */
public class FunctionException extends Exception {

    public FunctionException() {
        super();
    }

    public FunctionException(String message) {
        super(message);
    }

    public FunctionException(String message, Throwable cause) {
        super(message, cause);
    }

    public FunctionException(Throwable cause) {
        super(cause);
    }

}