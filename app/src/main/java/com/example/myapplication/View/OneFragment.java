package com.example.myapplication.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentOneBinding;


public class OneFragment extends Fragment {

    private FragmentOneBinding fragmentOneBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentOneBinding = FragmentOneBinding.inflate(inflater,container,false);
        View view = fragmentOneBinding.getRoot();

        //載入圖片
        fragmentOneBinding.ivImag.setImageResource(R.mipmap.img_no);

        return view;
    }

}