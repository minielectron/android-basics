package com.telekom.android.logger

object LogFramework {

    private var config = LoggerConfig(TimberLogger(), true, defaultLogLevel = LogLevel.DEBUG)

    fun init(config: LoggerConfig) {
        this.config = config
    }

    fun getConfig(): LoggerConfig = config
}
