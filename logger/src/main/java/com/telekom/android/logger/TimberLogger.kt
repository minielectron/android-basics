package com.telekom.android.logger

import javax.inject.Inject
import timber.log.Timber

class TimberLogger @Inject constructor() : Logger {

    init {
        if (Timber.treeCount == 0){
            Timber.plant(Timber.DebugTree())
        }
    }

    @Deprecated("Use the inline function for logging", replaceWith = ReplaceWith("Use Logger.log() method"))
    override fun log(tag: String, message: String, level: LogLevel) {
        when (level) {
            LogLevel.ERROR -> Timber.tag(tag).e(message)
            LogLevel.WARN -> Timber.tag(tag).w(message)
            LogLevel.INFO -> Timber.tag(tag).i(message)
            LogLevel.DEBUG -> Timber.tag(tag).d(message)
        }
    }
}
