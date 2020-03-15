package tinks.app.readkeeper.wishlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_wishlist.*
import tinks.app.readkeeper.R
import tinks.app.readkeeper.common.BasicProgressBar
import tinks.app.readkeeper.common.HasProgressBar

class WishlistFragment : Fragment(), HasProgressBar by BasicProgressBar() {

    private val model: WishlistViewModel by viewModels()
    var adapter = WishlistRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_wishlist, container, false)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)
//        wishlistViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        model.addBook()
        model.allBooks.observe(viewLifecycleOwner, Observer {
            adapter.updateBook(it)
            adapter.notifyDataSetChanged()
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wishlist_recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@WishlistFragment.adapter
        }
    }
}
