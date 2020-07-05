package com.okcodex.trymvc.screens.postListActivity

import com.okcodex.trymvc.model.pojo.Post
import com.okcodex.trymvc.screens.common.ObservableViewMvc

interface PostListViewMvc : ObservableViewMvc<PostListViewMvc.Listener> {


    interface Listener {
        fun onPostClicked(post: Post)
    }


    fun bindData(list: List<Post>)

}