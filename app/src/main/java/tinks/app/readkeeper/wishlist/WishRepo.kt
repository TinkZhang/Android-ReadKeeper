package tinks.app.readkeeper.wishlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object WishRepo {
    private var wishBooks = MutableLiveData<List<WishBook>>()

    fun getAllWish(): LiveData<List<WishBook>> {
        return wishBooks
    }

    fun addWishBook() {
        wishBooks.postValue(listOf(WishBook(title = "Book 1"), WishBook(title = "Book 2")))
    }
}