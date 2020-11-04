package com.fcfm.poi.plantilla.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fcfm.poi.plantilla.R
import com.fcfm.poi.plantilla.models.ChatAlert
import kotlinx.android.synthetic.main.item_view_chats.view.*

class ChatAlertAdapter(
    private val ChatAlertList: List<ChatAlert>,
    private val context: Context?,
    private val onClickListener: (View, ChatAlert) -> Unit
) :
    RecyclerView.Adapter<ChatAlertAdapter.ChatAlertViewHolder>() {

    class ChatAlertViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(currentAlert: ChatAlert) {
            itemView.username_chatalert.text = currentAlert.from
            itemView.descriptionchat.text = currentAlert.message
            //itemView.ivPicture.setImageBitmap(currentAlert.pictureUrl)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAlertViewHolder {
        return ChatAlertViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_chats, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ChatAlertViewHolder, position: Int) {
        val chat = ChatAlertList[position]
        holder.bindData(chat)
        holder.itemView.setOnClickListener { view ->
            onClickListener.invoke(view, chat)
        }
    }

    override fun getItemCount(): Int = ChatAlertList.size
}