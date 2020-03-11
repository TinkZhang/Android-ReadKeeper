package tinks.app.readkeeper.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tinks.app.readkeeper.R
import tinks.app.readkeeper.ReadKeeperApplication

class SearchResultRecycleViewAdapter(var searchBooks: List<SearchBook>) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return searchBooks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = searchBooks[position]
        val resource = ReadKeeperApplication.resourses
        holder.titleTextView?.text = book.title
        holder.authorTextView?.text = resource
            .getString(R.string.author_by, book.author)
        holder.publishTextView?.text = resource
            .getString(R.string.publish_in, book.originalPublicationYear)
        holder.ratingTextView?.text = resource
            .getString(R.string.rating, book.averageRating, book.ratingsCount)
    }

}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var titleTextView: TextView? = itemView.findViewById(R.id.title_textview)
    var authorTextView: TextView? = itemView.findViewById(R.id.author_textview)
    var publishTextView: TextView? = itemView.findViewById(R.id.publish_time_textview)
    var ratingTextView: TextView? = itemView.findViewById(R.id.rating_textview)
}
