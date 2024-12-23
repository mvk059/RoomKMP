package fyi.manpreet.roomkmp

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import fyi.manpreet.roomkmp.db.MemeDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

fun geMemeDatabase(): MemeDatabase {
    val dbFile = documentDirectory() + "/meme_table"
    return Room.databaseBuilder<MemeDatabase>(
        name = dbFile,
    )
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}