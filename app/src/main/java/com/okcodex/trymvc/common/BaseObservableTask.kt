package com.okcodex.trymvc.common

open class BaseObservableTask<ListenerType> {

    private var mListeners: MutableSet<ListenerType> = HashSet()

    fun registerListener(listener: ListenerType) {
        mListeners.add(listener)
    }

    fun unregisterListener(listener: ListenerType) {
        mListeners.remove(listener)
    }

    protected fun getListener(): Set<ListenerType> {
        return mListeners
    }


}