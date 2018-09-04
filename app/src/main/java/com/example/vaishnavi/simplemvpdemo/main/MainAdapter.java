package com.example.vaishnavi.simplemvpdemo.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vaishnavi.simplemvpdemo.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<String> items;
    private Listener listener;

    public MainAdapter(List<String> items, Listener listener) {
        this.listener = listener;
        this.items = items;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView v = (TextView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_main_item,viewGroup,false);
        return new MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
        final String item = items.get(i);
        mainViewHolder.textView.setText(item);
        mainViewHolder.textView.setOnClickListener(v -> listener.onItemClicked(item));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    interface Listener{
        void onItemClicked(String item);
    }

    static public class MainViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MainViewHolder(@NonNull TextView textView) {
            super(textView);
            this.textView = textView;
        }
    }
}
