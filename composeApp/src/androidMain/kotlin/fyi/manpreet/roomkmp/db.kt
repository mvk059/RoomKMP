package fyi.manpreet.roomkmp

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import fyi.manpreet.roomkmp.db.MemeDatabase
import kotlinx.coroutines.Dispatchers

fun getMemeDatabase(context: Context): MemeDatabase {
    val dbFile = context.getDatabasePath("meme_table")
    return Room.databaseBuilder<MemeDatabase>(
        context = context,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}