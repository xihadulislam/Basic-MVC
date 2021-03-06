package com.okcodex.trymvc.screens.postListActivity

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.okcodex.trymvc.R
import com.okcodex.trymvc.model.pojo.Post
import com.okcodex.trymvc.screens.common.BaseObservableViewMvc

class PostListItemViewMvcImpl(
    layoutInflater: LayoutInflater,
    parent: ViewGroup?
) : PostListItemViewMvc, BaseObservableViewMvc<PostListItemViewMvc.Listener>() {


    val title: TextView
    val number: TextView
    lateinit var mpost: Post

    init {
        setRootView(layoutInflater.inflate(R.layout.item_recyclerview, parent, false))
        title = findViewId(R.id.item_textView)
        number = findViewId(R.id.item_numbering)

        getRootView().setOnClickListener {
            for (listener: PostListItemViewMvc.Listener in getListener()) {
                Log.e("xyz", "PostListItemViewMvc")
                listener.onPostClicked(mpost)
            }
        }
    }

    override fun bindPosts(post: Post) {
        mpost = post
        title.text = post.title
        number.text = post.id.toString()
    }
}

