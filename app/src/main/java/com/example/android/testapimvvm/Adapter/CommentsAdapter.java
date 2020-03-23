package com.example.android.testapimvvm.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.testapimvvm.Pojo.Comment;
import com.example.android.testapimvvm.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.MyViewHolder> {
    List<Comment> mComment = new ArrayList<>();


    @NonNull
    @Override
    public CommentsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_layout_comment, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter.MyViewHolder holder, int position) {

        holder.idComment.setText(String.valueOf(mComment.get(position).getId()));
        holder.body.setText(mComment.get(position).getBody());


    }

    @Override
    public int getItemCount() {
        return mComment.size();
    }

    public void setList(List<Comment> mComment) {
        this.mComment = mComment;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView idComment, body;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            idComment = (TextView) itemView.findViewById(R.id.idComment);
            body = (TextView) itemView.findViewById(R.id.body);
        }
    }
}
