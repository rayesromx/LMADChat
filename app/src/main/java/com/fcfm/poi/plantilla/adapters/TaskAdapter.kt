package com.fcfm.poi.plantilla.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.fcfm.poi.plantilla.R

import com.fcfm.poi.plantilla.fragments.dummy.DummyContent.DummyItem
import com.fcfm.poi.plantilla.models.Task

class TaskAdapter(
    private val values: List<Task>
) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.title_task)
        val descriptionView: TextView = view.findViewById(R.id.description_task)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_task, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.title
        holder.descriptionView.text = item.description
    }

    override fun getItemCount(): Int = values.size
}