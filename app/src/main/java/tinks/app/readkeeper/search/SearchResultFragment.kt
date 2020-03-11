package tinks.app.readkeeper.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_search_result.*
import tinks.app.readkeeper.R

class SearchResultFragment : Fragment() {
    private var keyword: String? = null

    private lateinit var viewModel: SearchResultViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchResultViewModel::class.java)
//        viewModel.getSearchResults().observe(viewLifecycleOwner, Observer<List<SearchBook>> {
//            searchResultTextView.text = it.toString()
//        })
        keyword = arguments?.getString("searchKeyword")

        keyword?.let {
            SearchRepo().searchByKeyword(it) { searchResult, searchBooks ->
                search_result_recyclerview.apply {
                    this.adapter = SearchResultRecycleViewAdapter(searchBooks)
                    this.layoutManager = LinearLayoutManager(context)
                }
                progressBar.visibility = View.GONE

            }
        }


    }

}
