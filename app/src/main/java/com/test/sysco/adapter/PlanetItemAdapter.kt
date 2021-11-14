package com.test.sysco.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.sysco.R
import com.test.sysco.listener.PlanetItemClickListener
import com.test.sysco.model.Result
import kotlinx.android.synthetic.main.list_view_planet_item.view.*

/**
 * this adapter class use to adapt list-row (RecyclerView list)
 */
class PlanetItemAdapter(private val plantItems: List<Result>, private val context: Context, private val onItemClick: PlanetItemClickListener) : RecyclerView.Adapter<PlanetItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(context).inflate(R.layout.list_view_planet_item, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return plantItems.size;
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder?.itemView.mainLinearLayout.tag = position;
        holder?.itemView.mainLinearLayout.setOnClickListener(View.OnClickListener {

            val pos = it.tag as Int

            onItemClick.onPostItemClick(plantItems[pos])
        })

        holder?.itemView.planetNameTextView.text = plantItems[position].name
        holder?.itemView.climateTextView.text = plantItems[position].climate
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}