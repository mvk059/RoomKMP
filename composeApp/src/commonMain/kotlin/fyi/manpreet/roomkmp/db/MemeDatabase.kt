package fyi.manpreet.roomkmp.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

@Database(
    entities = [Meme::class],
    version = 1,
    exportSchema = true
)
@ConstructedBy(MemeDatabaseCtor::class)
abstract class MemeDatabase : RoomDatabase() {
    abstract fun memeDao(): MemeDao
}

expect object MemeDatabaseCtor : RoomDatabaseConstructor<MemeDatabase> {
    override fun initialize(): MemeDatabase
}