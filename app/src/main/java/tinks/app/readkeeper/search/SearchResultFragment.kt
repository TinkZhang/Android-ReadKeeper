package tinks.app.readkeeper.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.search_result_fragment.*
import tinks.app.readkeeper.R

class SearchResultFragment : Fragment() {
    private var keyword: String? = null

    private lateinit var viewModel: SearchResultViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_result_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchResultViewModel::class.java)
//        viewModel.getSearchResults().observe(viewLifecycleOwner, Observer<List<SearchBook>> {
//            searchResultTextView.text = it.toString()
//        })
        keyword = arguments?.getString("searchKeyword")

        keyword?.let {
            SearchRepo().searchByKeyword(it) { response ->
                val text: CharSequence = response
                searchResultTextView.text = text
            }
        }
    }

}
