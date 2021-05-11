package com.example.myapplication.View.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ItemDataBinding;

import java.util.List;

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.MyViewHolder> {

    private List<String> dataLists;

    public DataListAdapter(List<String> data) {
        dataLists = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemDataBinding binding = ItemDataBinding.inflate(layoutInflater, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DataListAdapter.MyViewHolder holder, int position) {
        final MyViewHolder data = holder;

        data.binding.tvDate.setText(dataLists.get(position));
    }

    @Override
    public int getItemCount() {
        return dataLists != null ? dataLists.size() : 0;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemDataBinding binding;

        MyViewHolder(ItemDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
