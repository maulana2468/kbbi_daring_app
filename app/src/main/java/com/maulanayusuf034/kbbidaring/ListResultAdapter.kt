package com.maulanayusuf034.kbbidaring

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.vipulasri.timelineview.TimelineView

class ListResultAdapter(private val listArti: ArrayList<String>) : RecyclerView.Adapter<ListResultAdapter.ListViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return TimelineView.getTimeLineViewType(position, itemCount)
    }

    inner class ListViewHolder(itemView: View, viewType: Int) : RecyclerView.ViewHolder(itemView) {
        private var timeLine: TimelineView = itemView.findViewById(R.id.timeline)
        var artiTextView: TextView = itemView.findViewById(R.id.arti_kata)

        init {
            timeLine.initLine(viewType)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_result_mean, parent, false)
        return ListViewHolder(view, viewType)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val arti = listArti[position]
        holder.artiTextView.text = arti
    }

    override fun getItemCount(): Int {
        return listArti.size
    }
}