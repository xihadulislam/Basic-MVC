package com.okcodex.trymvc.screens.common

import android.content.Context
import android.content.Intent
import com.okcodex.trymvc.common.Constants
import com.okcodex.trymvc.screens.postDetailsActivity.PostDetailsActivity

class ScreenNavigator(context: Context) {

    private val context: Context

    init {
        this.context = context
    }

    fun openPostDetailsActivity(id: Int) {
        val intent = Intent(context, PostDetailsActivity::class.java)
        intent.putExtra(Constants.POST_ID, id.toString())
        context.startActivity(intent)
    }

}