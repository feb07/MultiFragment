package com.feb.multifragment.struct;

/**
 * Created by lilichun on 2019/2/21.
 */
public abstract class FunctionWithResultOnly<Result> extends Function {
    public FunctionWithResultOnly(String mFunctionName) {
        super(mFunctionName);
    }
    public abstract Result function();
}
