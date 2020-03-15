package tinks.app.readkeeper.wishlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tinks.app.readkeeper.AppConfig
import tinks.app.readkeeper.R

class WishlistRecyclerViewAdapter() : RecyclerView.Adapter<ViewHolder>() {
    private var books: List<WishBook> = emptyList()
    var context: Context? = null

    fun updateBook(books: List<WishBook>) {
        this.books = books
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.wishlist_item, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = books[position]
        holder.titleTextView?.text = book.title
        holder.authorTextView?.text = context?.getString(R.string.author_by, book.author)

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
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var titleTextView: TextView? = itemView.findViewById(R.id.title_textview)
    var authorTextView: TextView? = itemView.findViewById(R.id.author_textview)
    var bookCoverImageView: ImageView? = itemView.findViewById(R.id.book_cover_imageview)
}

