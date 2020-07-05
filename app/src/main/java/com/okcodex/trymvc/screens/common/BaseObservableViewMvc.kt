package com.okcodex.trymvc.screens.common

abstract class BaseObservableViewMvc<ListenerType> : BaseViewMvc(),
    ObservableViewMvc<ListenerType> {
    private var mListeners: MutableSet<ListenerType> = HashSet()
    override fun registerListener(listener: ListenerType) {
        mListeners.add(listener)
    }

    override fun unregisterListener(listener: ListenerType) {
        mListeners.remove(listener)
    }

    protected fun getListener(): Set<ListenerType> {
        return mListeners
    }

}