package com.example.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private Fragment fragment;//tab切換時 紀錄當前頁面的fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        changeFragmentTab(0);

        binding.bBtn.setOnClickListener(this);

        initTab();
    }

    /**
     * 初始化TAB
     */
    private void initTab() {
        String[] title = new String[]{"TAB1", "TAB2"};

        for (String tab : title) {
            binding.tTab.addTab(binding.tTab.newTab().setText(tab));
        }

        /*選擇Tab*/
        binding.tTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                changeFragmentTab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * 選擇切換頁面
     * @param position
     */
    private void changeFragmentTab(int position) {
        switch (position) {
            case 0:
                oneFragment = oneFragment == null ? new OneFragment() : oneFragment;

                fragment = replaceFragment(R.id.f_Container,oneFragment);
                break;
            case 1:
                twoFragment = twoFragment == null ? new TwoFragment() : twoFragment;

                fragment = replaceFragment(R.id.f_Container,twoFragment);
                break;
        }
    }

    /**
     * 切換Fragment
     *  @param layout   layout頁面
     * @param fragment 替換的fragment
     * @return
     */
    private Fragment replaceFragment(int layout, final Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fm = fragmentManager.beginTransaction();

        fm.addToBackStack(null)//按下返回鍵回到上一個Fragment
                .replace(layout, fragment)
                .commit();

        return fragment;
    }

    @Override
    public void onClick(View view) {
        changeFragmentTab(1);
    }
}