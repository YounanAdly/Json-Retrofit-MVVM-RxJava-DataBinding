
package com.example.android.testapimvvm.Pojo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiPosts {

    public ApiPosts(){}
    @SerializedName("posts")
    @Expose
    private List<Post> posts;
    @SerializedName("comments")
    @Expose
    private List<Comment> comments;
    @SerializedName("profile")
    @Expose
    private Profile profile;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

}
