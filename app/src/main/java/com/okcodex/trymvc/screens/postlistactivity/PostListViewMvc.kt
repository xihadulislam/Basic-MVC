package com.okcodex.trymvc.screens.postlistactivity

import com.okcodex.trymvc.model.Post
import com.okcodex.trymvc.screens.common.ObservableViewMvc
import com.okcodex.trymvc.screens.common.ViewMvc

interface PostListViewMvc : ObservableViewMvc<PostListViewMvc.Listener> {


    interface Listener {
        fun onPostClicked(post: Post)
    }


    fun bindData(list: List<Post>)

}