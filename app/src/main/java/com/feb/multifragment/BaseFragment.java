package com.feb.multifragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.feb.multifragment.struct.FunctionManager;


/**
 * Created by lilichun on 2019/2/21.
 */
public class BaseFragment extends Fragment {

    public FunctionManager mFunctionManager;
    private MainActivity mBaseActivity;

    public void setmFunctionManager(FunctionManager mFunctionManager) {
        this.mFunctionManager = mFunctionManager;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            mBaseActivity = (MainActivity) context;
            mBaseActivity.initFunctionsForFragment(getTag());
        }
    }
}
