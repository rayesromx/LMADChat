package com.fcfm.poi.plantilla.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fcfm.poi.plantilla.R
import com.fcfm.poi.plantilla.models.GroupChat
import kotlinx.android.synthetic.main.item_view_group_chat.view.*

class GroupChatAdapter(
    private val GroupChatList: List<GroupChat>
) : RecyclerView.Adapter<GroupChatAdapter.GroupChatViewHolder>() {

    class GroupChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(currentAlert: GroupChat) {
            itemView.groupText.text = currentAlert.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupChatViewHolder {
        return GroupChatViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_group_chat, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GroupChatViewHolder, position: Int) {

        holder.bindData(GroupChatList[position])
    }

    override fun getItemCount(): Int = GroupChatList.size
}