package com.example.android.testapimvvm.data;

import com.example.android.testapimvvm.Pojo.ApiPosts;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("db")
    Single<ApiPosts> getPosts();
}
