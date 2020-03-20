package tinks.app.readkeeper.wishlist

import androidx.lifecycle.LiveData
import androidx.room.*
import tinks.app.readkeeper.common.BasicBook
import java.util.*

@Database(entities = arrayOf(WishBookEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wishDao(): WishDao
}

@Dao
interface WishDao {
    @Query("SELECT * FROM wishbookentity")
    fun getAll(): LiveData<List<WishBookEntity>>

    @Query("SELECT * FROM wishbookentity WHERE uid IN (:bookIds)")
    fun loadAllByIds(bookIds: IntArray): List<WishBookEntity>

    @Insert
    suspend fun insert(book: WishBookEntity)

    @Delete
    fun delete(book: WishBookEntity)

}

@Entity(ignoredColumns = ["imageUrl"])
data class WishBookEntity(
    @PrimaryKey val uid: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "title") override var title: String
) : BasicBook()