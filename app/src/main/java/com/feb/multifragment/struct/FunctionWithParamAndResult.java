package com.feb.multifragment.struct;

/**
 * Created by lilichun on 2019/2/21.
 */
public abstract class FunctionWithParamAndResult<Result, Param> extends Function {
    public FunctionWithParamAndResult(String mFunctionName) {
        super(mFunctionName);
    }

    public abstract Result function(Param param);
}
