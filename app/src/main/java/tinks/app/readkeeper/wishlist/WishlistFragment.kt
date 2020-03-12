package tinks.app.readkeeper.wishlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import tinks.app.readkeeper.R

class WishlistFragment : Fragment() {

    private lateinit var wishlistViewModel: WishlistViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        wishlistViewModel =
            ViewModelProviders.of(this).get(WishlistViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_wishlist, container, false)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)
//        wishlistViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }
}
