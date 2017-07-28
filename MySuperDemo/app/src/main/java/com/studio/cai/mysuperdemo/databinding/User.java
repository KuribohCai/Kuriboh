package com.studio.cai.mysuperdemo.databinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator Kuriboh on 2017/7/26.
 */

public class User {
    public String name;
    public String myBlog;
    public int age;
    public boolean isStudent;

    public User(String name,int age,String myBlog){
        this.name=name;
        this.age=age;
        this.myBlog=myBlog;
    }

    public String imageUrl;

    public User(String imageUrl){
        this.imageUrl=imageUrl;
    }

    /**
     * 使用ImageLoader显示图片
     * @param imageView
     * @param url
     */
    @BindingAdapter({"imageUrl"})
    public static void imageLoader(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMyBlog() {
        return myBlog;
    }

    public void setMyBlog(String myBlog) {
        this.myBlog = myBlog;
    }
}
