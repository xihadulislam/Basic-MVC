package com.okcodex.trymvc.screens.postlistactivity

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.okcodex.trymvc.R
import com.okcodex.trymvc.model.Post

class PostAdapter(layoutInflater: LayoutInflater) : RecyclerView.Adapter<PostAdapter.ViewHolder>(),
    PostListItemViewMvc.Listener {


    private var mlayoutInflater: LayoutInflater = layoutInflater
    private lateinit var postlist: List<Post>
    var mlistener: Listener? = null


    interface Listener {
        fun onPostClicked(post: Post)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val postListViewMvc: PostListItemViewMvc = PostListItemViewMvcImpl(mlayoutInflater, parent)
        postListViewMvc.registerListener(this)
        return ViewHolder(postListViewMvc)
    }

    fun setPostList(posts: List<Post>) {
        this.postlist = posts
        notifyDataSetChanged()
    }


    fun setListener(listener: Listener) {
        mlistener = listener
    }


    override fun getItemCount(): Int {
        if (this::postlist.isInitialized) return postlist.size
        else return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postListViewMvc.bindPosts(postlist[position])

    }


    class ViewHolder(val postListViewMvc: PostListItemViewMvc) :
        RecyclerView.ViewHolder(postListViewMvc.getRootView()) {
        val title: TextView = itemView.findViewById(R.id.item_textView)
    }


    override fun onPostClicked(post: Post) {

        mlistener?.onPostClicked(post)

    }


}