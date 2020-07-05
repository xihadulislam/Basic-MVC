package com.okcodex.trymvc.screens.postDetailsActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.okcodex.trymvc.R
import com.okcodex.trymvc.model.pojo.Post
import com.okcodex.trymvc.screens.common.BaseObservableViewMvc

class PostDetailsViewMvcImpl(layoutInflater: LayoutInflater, parent: ViewGroup?) :
    PostDetailsViewMvc, BaseObservableViewMvc<PostDetailsViewMvc.Listener>() {


    private val mTitle: TextView
    private val mBody: TextView

    init {
        setRootView(layoutInflater.inflate(R.layout.activity_post_details, parent, false))
        mTitle = findViewId(R.id.details_title)
        mBody = findViewId(R.id.details_body)

    }


    override fun bindPostDetails(post: Post) {
        mTitle.text = post.title
        mBody.text = post.body

    }

}