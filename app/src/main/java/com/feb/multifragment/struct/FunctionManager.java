package com.feb.multifragment.struct;

import android.text.TextUtils;

import java.util.HashMap;

/**
 * Created by lilichun on 2019/2/21.
 */
public class FunctionManager {
    private static FunctionManager ourInstance;

    public synchronized static FunctionManager getInstance() {
        if (ourInstance == null) {
            synchronized (FunctionManager.class) {
                ourInstance = new FunctionManager();
            }
        }
        return ourInstance;
    }

    private FunctionManager() {
        mFunctionNoParamNoResult = new HashMap<>();
        mFunctionWithParamOnly = new HashMap<>();
        mFunctionWithResultOnly = new HashMap<>();
        mFunctionWithParamAndResult = new HashMap<>();
    }

    private HashMap<String, FunctionNoParamNoResult> mFunctionNoParamNoResult;
    private HashMap<String, FunctionWithParamOnly> mFunctionWithParamOnly;
    private HashMap<String, FunctionWithResultOnly> mFunctionWithResultOnly;
    private HashMap<String, FunctionWithParamAndResult> mFunctionWithParamAndResult;

    /**
     * 添加
     *
     * @param function
     * @return
     */
    public FunctionManager addFunction(FunctionNoParamNoResult function) {
        mFunctionNoParamNoResult.put(function.mFunctionName, function);
        return this;
    }

    /**
     * 调用
     * 1.查找
     * 2.调用
     */
    public void invokeFunc(String functionName) throws FunctionException {
        if (TextUtils.isEmpty(functionName)) {
            return;
        }
        FunctionNoParamNoResult f;
        if (mFunctionNoParamNoResult != null) {
            f = mFunctionNoParamNoResult.get(functionName);
            if (f != null) {
                f.function();
            } else {
                throw new FunctionException("没有此function");
            }
        }
    }

    public FunctionManager addFunction(FunctionWithParamOnly function) {
        mFunctionWithParamOnly.put(function.mFunctionName, function);
        return this;
    }

    public <Param> void invokeFunc(String functionName, Param param) throws FunctionException {
        if (TextUtils.isEmpty(functionName)) {
            return;
        }
        FunctionWithParamOnly f;
        if (mFunctionWithParamOnly != null) {
            f = mFunctionWithParamOnly.get(functionName);
            if (f != null) {
                f.function(param);
            } else {
                throw new FunctionException("没有此function");
            }

        }
    }

    public FunctionManager addFunction(FunctionWithResultOnly function) {
        mFunctionWithResultOnly.put(function.mFunctionName, function);
        return this;
    }

    public <Result> Result invokeFunc(String functionName, Class<Result> clz) throws FunctionException {
        if (TextUtils.isEmpty(functionName)) {
            return null;
        }
        FunctionWithResultOnly f;
        if (mFunctionWithResultOnly != null) {
            f = mFunctionWithResultOnly.get(functionName);
            if (f != null) {
                if (clz != null) {
                    return clz.cast(f.function());
                } else {
                    return (Result) f.function();
                }

            } else {
                throw new FunctionException("没有此function");
            }
        }
        return null;
    }

    public FunctionManager addFunction(FunctionWithParamAndResult funtion) {
        mFunctionWithParamAndResult.put(funtion.mFunctionName, funtion);
        return this;
    }

    public <Param, Result> Result invokeFunc(String functionName, Param param, Class<Result> clz) throws FunctionException {
        if (TextUtils.isEmpty(functionName)) {
            return null;
        }
        FunctionWithParamAndResult f;
        if (mFunctionWithParamAndResult != null) {
            f = mFunctionWithParamAndResult.get(functionName);
            if (f != null) {
                if (clz != null) {
                    return clz.cast(f.function(param));
                } else {
                    return (Result) f.function(param);
                }
            } else {
                throw new FunctionException("没有此function");
            }
        }
        return null;
    }
}
