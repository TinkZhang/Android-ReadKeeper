package tinks.app.readkeeper.wishlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import tinks.app.readkeeper.ReadKeeperApplication

object WishRepo {
    private var wishBooks = MutableLiveData<List<WishBookEntity>>()
    private val db = Room.databaseBuilder(
        ReadKeeperApplication.instance.baseContext,
        AppDatabase::class.java,
        "database"
    ).build()

    fun getAllWish(): LiveData<List<WishBookEntity>> {
        return db.wishDao().getAll()
    }

    suspend fun addWishBook(book: WishBookEntity) {
        db.wishDao().insert(book)
    }

}