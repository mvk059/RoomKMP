package fyi.manpreet.roomkmp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MemeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeme(meme: Meme)

    @Query("SELECT * FROM meme_table")
    fun getAllMemes(): Flow<List<Meme>>

    @Delete
    suspend fun deleteMeme(meme: Meme)

}
