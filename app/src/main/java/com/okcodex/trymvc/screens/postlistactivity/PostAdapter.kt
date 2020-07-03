package com.okcodex.trymvc.screens.postlistactivity

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.okcodex.trymvc.R
import com.okcodex.trymvc.model.Post
import com.okcodex.trymvc.screens.common.ViewMvcFactory

class PostAdapter(viewMvcFactory: ViewMvcFactory) : RecyclerView.Adapter<PostAdapter.ViewHolder>(),
    PostListItemViewMvc.Listener {

    private var mViewMvcFactory: ViewMvcFactory = viewMvcFactory

    private lateinit var postList: List<Post>
    var mlistener: Listener? = null


    interface Listener {
        fun onPostClicked(post: Post)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val postListViewMvc: PostListItemViewMvc = mViewMvcFactory.getPostItemListViewMvc(parent)
        postListViewMvc.registerListener(this)
        return ViewHolder(postListViewMvc)
    }

    fun setPostList(posts: List<Post>) {
        this.postList = posts
        notifyDataSetChanged()
    }


    fun setListener(listener: Listener) {
        mlistener = listener
    }


    override fun getItemCount(): Int {
        if (this::postList.isInitialized)  return postList.size
        else return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postListViewMvc.bindPosts(postList[position])
    }

    class ViewHolder(val postListViewMvc: PostListItemViewMvc) : RecyclerView.ViewHolder(postListViewMvc.getRootView())

    override fun onPostClicked(post: Post) {

        mlistener?.onPostClicked(post)

    }


}