package com.okcodex.trymvc.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.okcodex.trymvc.common.dependencyinjection.CompositionRoot
import com.okcodex.trymvc.common.dependencyinjection.ControllerCompositionRoot
import com.okcodex.trymvc.screens.MyApp

open class BaseActivity : AppCompatActivity() {


    private lateinit var mControllerCompositionRoot: ControllerCompositionRoot

    protected  fun getCompositionRoot():ControllerCompositionRoot {
        if (!this::mControllerCompositionRoot.isInitialized) mControllerCompositionRoot = ControllerCompositionRoot((application as MyApp).getCompositionRoot(),this)

        return mControllerCompositionRoot

    }



}