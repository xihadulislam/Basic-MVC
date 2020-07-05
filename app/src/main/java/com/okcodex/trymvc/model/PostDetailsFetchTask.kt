package com.okcodex.trymvc.model

import android.widget.Toast
import com.okcodex.trymvc.common.BaseObservableTask
import com.okcodex.trymvc.model.pojo.Post
import com.okcodex.trymvc.networking.PostService
import com.okcodex.trymvc.screens.common.BaseObservableViewMvc
import retrofit2.Call
import retrofit2.Response

class PostDetailsFetchTask(postService: PostService) :
    BaseObservableTask<PostDetailsFetchTask.Listener>() {


    interface Listener {
        fun onPostDetailsLoaded(post: Post)
        fun onPostDetailsLoadFailed()

    }

    private val mPostService: PostService

    init {
        mPostService = postService
    }


    fun postDetailsFetched(postId: Int) {

        val requestCall = mPostService.getPostDetails(postId)

        requestCall.enqueue(object : retrofit2.Callback<Post> {

            override fun onResponse(call: Call<Post>, response: Response<Post>) {

                if (response.isSuccessful) {
                    val post = response.body()!!
                    fetchedSuccess(post)

                } else {
                    fetchedFailure()
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                fetchedFailure()
            }

        })

    }


    private fun fetchedSuccess(post: Post) {

        for (listener: Listener in getListener()) {
            listener.onPostDetailsLoaded(post)

        }

    }

    private fun fetchedFailure() {
        for (listener: Listener in getListener()) {
            listener.onPostDetailsLoadFailed()

        }

    }


}