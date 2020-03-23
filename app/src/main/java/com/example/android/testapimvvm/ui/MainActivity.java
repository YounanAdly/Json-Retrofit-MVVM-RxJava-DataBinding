package com.example.android.testapimvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.android.testapimvvm.Adapter.CommentsAdapter;
import com.example.android.testapimvvm.Adapter.PostsAdapter;
import com.example.android.testapimvvm.R;
import com.example.android.testapimvvm.ViewModel.PostsViewModel;
import com.example.android.testapimvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    PostsViewModel postsViewModel;
    PostsAdapter mAdapter;
    CommentsAdapter commentsAdapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel.class);
        postsViewModel.getPosts();

        PostsViewModel.postsMutableLiveData.observe(this, apiPosts -> {
            mAdapter.setList(apiPosts.getPosts());
            commentsAdapter.setList(apiPosts.getComments());
            binding.profile.setText(apiPosts.getProfile().getName());

        });

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        if (mAdapter == null) {
            mAdapter = new PostsAdapter();
            binding.postsRecycler.setLayoutManager(new LinearLayoutManager(this));
            binding.postsRecycler.setAdapter(mAdapter);
            binding.postsRecycler.setItemAnimator(new DefaultItemAnimator());
            binding.postsRecycler.setNestedScrollingEnabled(true);
        } else {
            mAdapter.notifyDataSetChanged();
        }


        if (commentsAdapter == null) {
            commentsAdapter = new CommentsAdapter();
            binding.commentRecycler.setLayoutManager(new LinearLayoutManager(this));
            binding.commentRecycler.setAdapter(commentsAdapter);
            binding.commentRecycler.setItemAnimator(new DefaultItemAnimator());
            binding.commentRecycler.setNestedScrollingEnabled(true);
        } else {
            commentsAdapter.notifyDataSetChanged();
        }
    }

}
