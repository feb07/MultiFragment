package com.feb.multifragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.feb.multifragment.struct.FunctionException;
import com.feb.multifragment.struct.FunctionManager;

/**
 * Created by lilichun on 2019/2/21.
 */
public class FirstFragment extends BaseFragment {

    public static final String INTERFACE_NO_PARAM_NO_RESULT = FirstFragment.class.getName() + "no_param_no_result";
    public static final String INTERFACE_ONLY_PARAM = FirstFragment.class.getName() + "onlyParam";
    public static final String INTERFACE_ONLY_RESULT = FirstFragment.class.getName() + "only_reuslt";
    public static final String INTERFACE_PARAM_AND_RESULT = FirstFragment.class.getName() + "param_and_result";
    private Button btn_no_param_no_result;
    private Button btn_only_param;
    private Button btn_only_result;
    private Button btn_param_and_result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_first, null);
        btn_no_param_no_result = view.findViewById(R.id.btn_no_param_no_result);
        btn_no_param_no_result.setOnClickListener(new ClickListener());

        btn_only_param = view.findViewById(R.id.btn_only_param);
        btn_only_param.setOnClickListener(new ClickListener());
        btn_only_result = view.findViewById(R.id.btn_only_result);
        btn_only_result.setOnClickListener(new ClickListener());
        btn_param_and_result = view.findViewById(R.id.btn_param_and_result);
        btn_param_and_result.setOnClickListener(new ClickListener());
        return view;
    }

    class ClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            btnClick(v);
        }
    }


    public void btnClick(View view) {
        if (view == btn_no_param_no_result) {
            try {
                FunctionManager.getInstance().invokeFunc(INTERFACE_NO_PARAM_NO_RESULT);
            } catch (FunctionException e) {
                e.printStackTrace();
            }
        } else if (view == btn_only_param) {
            try {
                FunctionManager.getInstance().invokeFunc(INTERFACE_ONLY_PARAM, "this is param");
            } catch (FunctionException e) {
                e.printStackTrace();
            }
        } else if (view == btn_only_result) {
            try {
                String str = FunctionManager.getInstance().invokeFunc(INTERFACE_ONLY_RESULT, String.class);
                Toast.makeText(getContext(), "++成功调用无入参有返回值接口,返回值：" + str, Toast.LENGTH_SHORT).show();
            } catch (FunctionException e) {
                e.printStackTrace();
            }
        } else if (view == btn_param_and_result) {
            try {
                String str = FunctionManager.getInstance().invokeFunc(INTERFACE_PARAM_AND_RESULT,"this is param",String.class);
                Toast.makeText(getContext(), "--成功调用有入参有返回值接口,返回值：" + str, Toast.LENGTH_SHORT).show();

            } catch (FunctionException e) {
                e.printStackTrace();
            }
        }

    }
}
