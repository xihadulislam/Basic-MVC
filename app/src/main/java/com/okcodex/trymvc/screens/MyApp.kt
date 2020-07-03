package com.okcodex.trymvc.screens

import android.app.Application
import com.okcodex.trymvc.common.dependencyinjection.CompositionRoot

class MyApp  : Application() {

private lateinit var  mCompositionRoot: CompositionRoot

    override fun onCreate() {
        super.onCreate()
        mCompositionRoot = CompositionRoot()
    }


    fun getCompositionRoot(): CompositionRoot {
        return mCompositionRoot
    }


}