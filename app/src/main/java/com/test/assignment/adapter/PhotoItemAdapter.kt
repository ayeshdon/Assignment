package com.test.assignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.test.assignment.R
import com.test.assignment.listener.PlanetItemClickListener
import com.test.assignment.model.Photos
import kotlinx.android.synthetic.main.list_view_planet_item.view.*

/**
 * this adapter class use to adapt Grid item
 */
class PhotoItemAdapter(private var photoItems: ArrayList<Photos?>,
                       private val context: Context,
                       private val paginationListener: PlanetItemClickListener)
    : RecyclerView.Adapter<PhotoItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(context).inflate(R.layout.list_view_planet_item, parent,
                false)
        return ViewHolder(v)


    }

    override fun getItemCount(): Int {
        return photoItems.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photoItems[position]
        Picasso.get()
                .load(photo!!.src.medium)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder?.itemView.mainImageView);


        holder?.itemView.photographerTextView.text = photo.photographer

        /**
         * once scroll down to bottom then start pagination
         */
        if (position == itemCount - 1) {
            paginationListener.onPagination()
        }


    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}