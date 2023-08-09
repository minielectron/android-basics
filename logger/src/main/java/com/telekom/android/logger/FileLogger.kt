package com.telekom.android.logger

import android.content.Context
import java.io.File
import java.io.RandomAccessFile
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.Executors

class FileLogger (private val context: Context) : Logger {

    private val maxFileSize = 15 * 1024 * 1024 // 15MB

    private val logFile: File by lazy {
        val timestamp = SimpleDateFormat("yyyyMMdd_HH:mm:ss", Locale.US).format(Date())
        val fileName = "tv.log"
        File(context.cacheDir, fileName)
    }

    @Deprecated("Use the inline function for logging")
    override fun log(tag: String, message: String, level: LogLevel) {
        val logMessage = "${Date()} [$level/${tag}]: $message\n"
        Executors.newSingleThreadExecutor().execute {
            writeToFile(logMessage)
        }
    }

    @Synchronized
    private fun writeToFile(logMessage: String) {
        try {
            if (!logFile.exists()) {
                logFile.createNewFile()
            }

            // Check if file size exceeds the limit
            if (logFile.length() + logMessage.length > maxFileSize) {
                truncateFile(logMessage.length)
            }

            logFile.appendText(logMessage)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun truncateFile(size: Int) {
        RandomAccessFile(logFile, "rw").use { raf ->
            val requiredBytes = ByteArray(size)
            raf.seek(0)
            raf.read(requiredBytes, 0, size)
            raf.setLength(0)
            raf.write(requiredBytes)
        }
    }
}
