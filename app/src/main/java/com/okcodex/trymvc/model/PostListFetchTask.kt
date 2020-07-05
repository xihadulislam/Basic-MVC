package com.okcodex.trymvc.model

import android.widget.Toast
import com.okcodex.trymvc.common.BaseObservableTask
import com.okcodex.trymvc.model.pojo.Post
import com.okcodex.trymvc.networking.PostService
import retrofit2.Call
import retrofit2.Response

class PostListFetchTask(postService: PostService) :
    BaseObservableTask<PostListFetchTask.Listener>() {

    interface Listener {
        fun onPostListLoaded(list: List<Post>)
        fun onPostListLoadFailed()
    }

    private val mPostService: PostService

    init {
        mPostService = postService
    }

    fun postListFetched() {
        val requestCall = mPostService.getPosts()

        requestCall.enqueue(object : retrofit2.Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                fetchedFailure()
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val postList = response.body()!!
                    fetchedSuccess(postList)
                } else {
                    fetchedFailure()
                }

            }

        })


    }

    private fun fetchedSuccess(list: List<Post>) {
        for (listener: Listener in getListener()) {
            listener.onPostListLoaded(list)
        }
    }

    private fun fetchedFailure() {
        for (listener: Listener in getListener()) {
            listener.onPostListLoadFailed()
        }
    }

}