package com.telekom.android.logger

data class LoggerConfig(
    val logger: Logger,
    val enableLog: Boolean = true,
    val defaultLogLevel: LogLevel = LogLevel.DEBUG
)
