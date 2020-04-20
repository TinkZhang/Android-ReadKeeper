package tinks.app.readkeeper.wishlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WishlistViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Wishlist Fragment"
    }
    val text: LiveData<String> = _text

    var allBooks = WishRepo.getAllWish()

    fun addBook(book: WishBookEntity) {
        viewModelScope.launch {
            WishRepo.addWishBook(book)
        }
    }
}