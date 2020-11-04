package com.fcfm.poi.plantilla.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fcfm.poi.plantilla.R
import com.fcfm.poi.plantilla.models.Alert
import com.fcfm.poi.plantilla.models.Mensaje
import kotlinx.android.synthetic.main.item_view_alert.view.*

class ChatRoomAdapter(private val mensajeList: List<Mensaje>) :
    RecyclerView.Adapter<ChatRoomAdapter.ChatRoomViewHolder>() {

    class ChatRoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(msj: Mensaje) {
            itemView.user_message_time.text = ""
            itemView.user_message.text = msj.contenido
            //itemView.ivPicture.setImageBitmap(currentAlert.pictureUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatRoomViewHolder {
        return ChatRoomViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_chat_room_logged_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ChatRoomViewHolder, position: Int) {
        holder.bindData(mensajeList[position])
    }

    override fun getItemCount(): Int = mensajeList.size
}
