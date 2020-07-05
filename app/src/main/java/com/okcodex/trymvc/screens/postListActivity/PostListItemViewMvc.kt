package com.okcodex.trymvc.screens.postListActivity

import com.okcodex.trymvc.model.pojo.Post
import com.okcodex.trymvc.screens.common.ObservableViewMvc

interface PostListItemViewMvc : ObservableViewMvc<PostListItemViewMvc.Listener> {

    interface Listener {
        fun onPostClicked(post: Post)
    }

    fun bindPosts(post: Post)

}