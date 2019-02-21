package com.feb.multifragment.struct;

/**
 * Created by lilichun on 2019/2/21.
 */
public abstract class FunctionWithParamOnly<Param> extends Function {

    public FunctionWithParamOnly(String mFunctionName) {
        super(mFunctionName);
    }

    public abstract void function(Param param);
}
