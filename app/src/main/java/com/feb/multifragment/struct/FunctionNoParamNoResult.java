package com.feb.multifragment.struct;

/**
 * Created by lilichun on 2019/2/21.
 * 无入参。无返回值的接口
 */
public abstract class FunctionNoParamNoResult extends Function {
    public FunctionNoParamNoResult(String functionName) {
        super(functionName);
    }
    public abstract void function();
}
