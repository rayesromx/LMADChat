package com.fcfm.poi.plantilla.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fcfm.poi.plantilla.R
import com.fcfm.poi.plantilla.models.Mensaje
import kotlinx.android.synthetic.main.item_view_alert.view.*



class GroupChatRoomAdapter(private val mensajeList: List<Mensaje>) :
    RecyclerView.Adapter<GroupChatRoomAdapter.GroupChatRoomViewHolder>() {

    private val MESSAGE_TYPE_LEFT = 0
    private val MESSAGE_TYPE_RIGHT = 1

    class GroupChatRoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(msj: Mensaje) {
            itemView.user_message_time.text = msj.de
            itemView.user_message.text = msj.contenido
            //itemView.ivPicture.setImageBitmap(currentAlert.pictureUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupChatRoomViewHolder {
        if(viewType == MESSAGE_TYPE_LEFT)
        {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_chat_room_msg_right, parent, false)
            return GroupChatRoomViewHolder(view)
        }
        else
        {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_chat_room_msg_left, parent, false)
            return GroupChatRoomViewHolder(view)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(mensajeList[position].esMio)
            return MESSAGE_TYPE_RIGHT
        return MESSAGE_TYPE_LEFT
    }

    override fun onBindViewHolder(holder: GroupChatRoomViewHolder, position: Int) {
        holder.bindData(mensajeList[position])
    }

    override fun getItemCount(): Int = mensajeList.size
}
