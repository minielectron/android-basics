package com.telekom.android.logger

interface Logger {
    // We have deprecated this to avoid the usage of this method directly as we will use
    // inline function which is more memory optimized and efficient in writing logs.
    @Deprecated(message = "Use the inline function for logging")
    fun log(tag: String, message: String, level: LogLevel = LogLevel.DEBUG)
}

inline fun Logger.log(tag: String? = null, message: () -> String, level: LogLevel = LogLevel.DEBUG) {
    if (!LogFramework.getConfig().enableLog) return
    var finalTag = getClassName()
    tag?.let { finalTag = it }
    log(finalTag, message.invoke(), level)
}

fun getClassName(): String {
    val stackTrace = Throwable().stackTrace
    return if (stackTrace.size > 2) {
        val className = stackTrace[2].className
        className.substring(className.lastIndexOf('.') + 1)
    } else {
        "UnknownClass"
    }
}