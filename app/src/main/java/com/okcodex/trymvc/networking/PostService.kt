package com.okcodex.trymvc.networking

import com.okcodex.trymvc.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    fun getPosts(): Call<List<Post>>

}