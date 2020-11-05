package com.fcfm.poi.plantilla.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fcfm.poi.plantilla.R
import com.fcfm.poi.plantilla.adapters.ChatRoomAdapter
import com.fcfm.poi.plantilla.adapters.GroupChatRoomAdapter
import com.fcfm.poi.plantilla.models.Mensaje
import kotlinx.android.synthetic.main.fragment_chat_room.view.*
import kotlinx.android.synthetic.main.fragment_group_chat.view.*

class FragmentGroupChatRoom : Fragment() {
    private lateinit var rootView: View
    private lateinit var adapter: GroupChatRoomAdapter
    private val list = mutableListOf<Mensaje>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_chat_room, container, false)
        loadMensajes()
        return rootView
    }

    private fun loadMensajes() {

        for (i in 0..15) {
            if(i%2==0)
                list.add(Mensaje(de = "Brenda Esparza", contenido = "Que onda", esMio = false))
            else if(i%3==0)
                list.add(Mensaje(de = "Mario Brodel", contenido = "Hola", esMio = false))
            else
                list.add(Mensaje(de = "Luis Brodel", contenido = "Que tal x $i", esMio = true))
        }

        adapter = GroupChatRoomAdapter(list)
        rootView.rvChatRoom.adapter = adapter
    }
}