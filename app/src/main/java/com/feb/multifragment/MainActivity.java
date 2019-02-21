package com.feb.multifragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.feb.multifragment.struct.FunctionManager;
import com.feb.multifragment.struct.FunctionNoParamNoResult;
import com.feb.multifragment.struct.FunctionWithParamAndResult;
import com.feb.multifragment.struct.FunctionWithParamOnly;
import com.feb.multifragment.struct.FunctionWithResultOnly;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FirstFragment firstFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        firstFragment = new FirstFragment();
        ft.add(R.id.content, firstFragment, "first");
        ft.commit();
    }

    /**
     * 初始化frament 调用
     */
    public void initFunctionsForFragment(String tag) {
        fragmentManager = getSupportFragmentManager();
        BaseFragment fragment = (BaseFragment) fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            FunctionManager fmanager = FunctionManager.getInstance();
            fragment.setmFunctionManager(fmanager.addFunction(new FunctionNoParamNoResult(FirstFragment.INTERFACE_NO_PARAM_NO_RESULT) {
                @Override
                public void function() {
                    Toast.makeText(MainActivity.this, "成功调用no_param_no_result的接口", Toast.LENGTH_SHORT).show();
                }
            }).addFunction(new FunctionWithParamOnly<String>(FirstFragment.INTERFACE_ONLY_PARAM) {

                @Override
                public void function(String o) {
                    Toast.makeText(MainActivity.this, "成功调用only_param的接口，入参：" + o, Toast.LENGTH_SHORT).show();

                }
            }).addFunction(new FunctionWithResultOnly<String>(FirstFragment.INTERFACE_ONLY_RESULT) {
                @Override
                public String function() {
                    return "today is 2019-2-21";
                }
            }).addFunction(new FunctionWithParamAndResult<String, String>(FirstFragment.INTERFACE_PARAM_AND_RESULT) {
                @Override
                public String function(String o) {
                    return "tomorrow is 2019-2-22";
                }
            }));
        }

    }
}
