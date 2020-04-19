package tinks.app.readkeeper.wishlist

import androidx.lifecycle.LiveData
import androidx.room.*
import tinks.app.readkeeper.common.BasicBook
import tinks.app.readkeeper.search.SearchBook
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

@Entity
data class WishBookEntity(
    @PrimaryKey val uid: String = UUID.randomUUID().toString(),
    override var title: String = "",
    override var imageUrl: String = "",
    override var author: String = "",
    override var pages: Int = 0,
    override var addedTime: Long = 0,
    override var rating: Double = 0.0
) : BasicBook() {
    constructor(searchBook: SearchBook) : this(
        title = searchBook.title,
        imageUrl = searchBook.imageUrl,
        author = searchBook.author,
        pages = searchBook.pages,
        addedTime = 0,
        rating = searchBook.rating
    )
}