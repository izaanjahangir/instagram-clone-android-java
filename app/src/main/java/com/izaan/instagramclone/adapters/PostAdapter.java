package com.izaan.instagramclone.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.izaan.instagramclone.R;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private Context context;
    private String[] localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public PostAdapter(Context ct, String[] dataSet) {
        localDataSet = dataSet;
        context = ct;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater
                .inflate(R.layout.post_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTextView().setText(localDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
