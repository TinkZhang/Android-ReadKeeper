package tinks.app.readkeeper.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchResultViewModel : ViewModel() {
    private val searchResults: MutableLiveData<List<SearchBook>> by lazy {
        MutableLiveData<List<SearchBook>>().also {
            loadsResult()
        }
    }

    fun getSearchResults(): LiveData<List<SearchBook>> {
        return searchResults
    }

    private fun loadsResult() {
//        searchResults.postValue(listOf(SearchBook("Hello world"), SearchBook("Welcome")))
    }
}
