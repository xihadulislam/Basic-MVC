package com.okcodex.trymvc.screens.postlistactivity

import com.okcodex.trymvc.model.Post
import com.okcodex.trymvc.screens.common.ObservableViewMvc

interface PostListItemViewMvc : ObservableViewMvc<PostListItemViewMvc.Listener> {

    interface Listener {
        fun onPostClicked(post: Post)
    }

    fun bindPosts(post: Post)

}