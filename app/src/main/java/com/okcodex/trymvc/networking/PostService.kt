package com.okcodex.trymvc.networking

import com.okcodex.trymvc.model.pojo.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {

    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("posts/{id}")
    fun getPostDetails(@Path("id") id: Int): Call<Post>

}

