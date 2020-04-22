package tinks.app.readkeeper.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import tinks.app.readkeeper.AppConfig
import tinks.app.readkeeper.R
import tinks.app.readkeeper.common.Utils
import tinks.app.readkeeper.wishlist.WishBookEntity
import tinks.app.readkeeper.wishlist.WishRepo

class SearchResultRecycleViewAdapter(var searchBooks: List<SearchBook>) :
    RecyclerView.Adapter<ViewHolder>() {

    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return searchBooks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = searchBooks[position]
        holder.titleTextView?.text = book.title
        holder.authorTextView?.text = context?.getString(R.string.author_by, book.author)
        when (book.originalPublicationYear) {
            0 -> holder.publishTextView?.visibility = View.GONE
            else -> {
                holder.publishTextView?.text = context?.getString(
                    R.string.publish_in,
                    book.originalPublicationYear
                )
                holder.publishTextView?.visibility = View.VISIBLE
            }
        }
        holder.ratingTextView?.text =
            context?.getString(R.string.rating, book.rating, book.ratingsCount)
        context?.let {
            holder.bookCoverImageView?.let { imageView ->
                if (book.imageUrl != AppConfig.DEFAULT_GOODREADER_IMAGE) {
                    Glide.with(it)
                        .load(book.imageUrl)
                        .placeholder(R.drawable.ic_book_default_cover)
                        .into(imageView)
                } else {
                    Glide.with(it)
                        .load(R.drawable.ic_book_default_cover)
                        .into(imageView)
                }
            }
        }

        holder.addWishButton?.apply {
            background = Utils.tintDrawableWithStateList(
                R.drawable.ic_wish, R.color.toggle_selector
            )
            setOnCheckedChangeListener { buttonView, isChecked ->
                when (this.isChecked) {
                    true -> GlobalScope.launch {
                        WishRepo.addWishBook(WishBookEntity(book))
                    }
                    false -> GlobalScope.launch {
                        WishRepo.addWishBook(WishBookEntity(book))
                    }
                }

                Utils.throb(buttonView)
            }
        }

        holder.addReadingButton?.apply {
            background = Utils.tintDrawableWithStateList(
                R.drawable.ic_reading_toggle, R.color.toggle_selector
            )
            setOnCheckedChangeListener { buttonView, isChecked ->
                when (this.isChecked) {
                    true -> GlobalScope.launch {
                        WishRepo.addWishBook(WishBookEntity(book))
                    }
                    false -> GlobalScope.launch {
                        WishRepo.addWishBook(WishBookEntity(book))
                    }
                }

                Utils.throb(buttonView)
            }
        }

        holder.addArchivedButton?.apply {
            background = Utils.tintDrawableWithStateList(
                R.drawable.ic_archive, R.color.toggle_selector
            )
            setOnCheckedChangeListener { buttonView, isChecked ->
                when (this.isChecked) {
                    true -> GlobalScope.launch {
                        WishRepo.addWishBook(WishBookEntity(book))
                    }
                    false -> GlobalScope.launch {
                        WishRepo.addWishBook(WishBookEntity(book))
                    }
                }

                Utils.throb(buttonView)
            }
        }
    }

}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var titleTextView: TextView? = itemView.findViewById(R.id.title_textview)
    var authorTextView: TextView? = itemView.findViewById(R.id.author_textview)
    var publishTextView: TextView? = itemView.findViewById(R.id.publish_time_textview)
    var ratingTextView: TextView? = itemView.findViewById(R.id.rating_textview)
    var bookCoverImageView: ImageView? = itemView.findViewById(R.id.book_cover_imageview)
    var addWishButton: ToggleButton? = itemView.findViewById(R.id.add_wish_button)
    var addReadingButton: ToggleButton? = itemView.findViewById(R.id.add_reading_button)
    var addArchivedButton: ToggleButton? = itemView.findViewById(R.id.add_archived_button)
}
