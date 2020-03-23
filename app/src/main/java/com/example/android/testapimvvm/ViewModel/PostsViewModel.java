package com.example.android.testapimvvm.ViewModel;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.android.testapimvvm.Pojo.ApiPosts;
import com.example.android.testapimvvm.Pojo.Profile;
import com.example.android.testapimvvm.data.PostsClient;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PostsViewModel extends ViewModel {

    private static final String TAG = "PostsViewModel";
    public static MutableLiveData<ApiPosts> postsMutableLiveData = new MutableLiveData<>();
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void getPosts() {
        Single<ApiPosts> observable = PostsClient.getINSTANCE().getPostsClient()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        compositeDisposable.add(observable.subscribe(o -> postsMutableLiveData.setValue(o), e -> Log.d(TAG, "getPosts: " + e)));
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
