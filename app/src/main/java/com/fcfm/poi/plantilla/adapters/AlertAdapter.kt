package com.fcfm.poi.plantilla.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fcfm.poi.plantilla.R
import com.fcfm.poi.plantilla.models.Alert
import kotlinx.android.synthetic.main.item_view_alert.view.*

class AlertAdapter(private val alertList: List<Alert>) :
    RecyclerView.Adapter<AlertAdapter.AlertViewHolder>() {

    class AlertViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(currentAlert: Alert) {
            itemView.username_alert.text = currentAlert.from
            itemView.user_message.text = currentAlert.message
            //itemView.ivPicture.setImageBitmap(currentAlert.pictureUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlertViewHolder {
        return AlertViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_alert, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AlertViewHolder, position: Int) {

        holder.bindData(alertList[position])
    }

    override fun getItemCount(): Int = alertList.size
}