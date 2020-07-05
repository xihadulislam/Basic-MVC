package com.okcodex.trymvc.screens.postDetailsActivity

import com.okcodex.trymvc.model.pojo.Post
import com.okcodex.trymvc.screens.common.ObservableViewMvc


interface PostDetailsViewMvc : ObservableViewMvc<PostDetailsViewMvc.Listener> {

    interface Listener {

    }

    fun bindPostDetails(post: Post)


}