package tinks.app.readkeeper.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.mancj.materialsearchbar.MaterialSearchBar
import kotlinx.android.synthetic.main.fragment_home.*
import tinks.app.readkeeper.R


class HomeFragment : Fragment(), MaterialSearchBar.OnSearchActionListener,
    PopupMenu.OnMenuItemClickListener {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //enable searchbar callbacks
        searchBar.setOnSearchActionListener(this)
        //Inflate menu and setup OnMenuItemClickListener
        searchBar.inflateMenu(R.menu.menu)
        searchBar.menu.setOnMenuItemClickListener(this)
    }

    override fun onButtonClicked(buttonCode: Int) {
        when (buttonCode) {
            MaterialSearchBar.BUTTON_BACK -> searchBar.closeSearch()
        }
    }

    override fun onSearchStateChanged(enabled: Boolean) {
    }

    override fun onSearchConfirmed(text: CharSequence?) {
        Toast.makeText(context, "Searching " + text.toString(), Toast.LENGTH_LONG).show()
        searchBar.closeSearch()
        var bundle = bundleOf("searchKeyword" to text.toString())
        findNavController().navigate(R.id.action_navigation_home_to_searchResultFragment, bundle)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
