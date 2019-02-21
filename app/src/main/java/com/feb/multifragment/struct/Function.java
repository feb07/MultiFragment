package com.feb.multifragment.struct;

/**
 * Created by lilichun on 2019/2/21.
 * 接口组成
 * 1.函数名
 * 2.入参
 * 3.返回值
 * 4.没有实现的函数体
 */
public abstract class Function {
    public String mFunctionName;

    public Function(String mFunctionName) {
        this.mFunctionName = mFunctionName;
    }
}
