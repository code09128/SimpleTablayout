package com.example.myapplication.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Model.DataList;
import com.example.myapplication.R;
import com.example.myapplication.View.Adapter.DataListAdapter;
import com.example.myapplication.databinding.FragmentOneBinding;
import com.example.myapplication.databinding.FragmentTwoBinding;

import java.util.ArrayList;
import java.util.List;

public class TwoFragment extends Fragment {

    private FragmentTwoBinding fragmentTwoBinding;
    DataListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentTwoBinding = FragmentTwoBinding.inflate(inflater,container,false);
        View view = fragmentTwoBinding.getRoot();

        init();

        return view;
    }

    /**初始化資料*/
    private void init() {
        List<String> listStr = new ArrayList<>();
        for (int i=0 ; i<7 ;i++){
            listStr.add(Integer.toString(i));
        }

        fragmentTwoBinding.rRecycleView.setHasFixedSize(true);
        fragmentTwoBinding.rRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new DataListAdapter(listStr);
        fragmentTwoBinding.rRecycleView.setAdapter(adapter);
    }
}