package com.fcfm.poi.plantilla.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fcfm.poi.plantilla.R
import com.fcfm.poi.plantilla.adapters.ChatRoomAdapter
import com.fcfm.poi.plantilla.models.Mensaje
import kotlinx.android.synthetic.main.fragment_chat_room.view.*
import kotlinx.android.synthetic.main.fragment_group_chat.view.*

class FragmentChatRoom : Fragment() {
    private lateinit var rootView: View
    private lateinit var adapter: ChatRoomAdapter
    private val list = mutableListOf<Mensaje>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_group_chat, container, false)
        loadMensajes()
        return rootView
    }

    private fun loadMensajes() {
       for (i in 0..10) {
           if(i%2==0)
            list.add(Mensaje(de = "Mario Cabrera", contenido = "Hola", esMio = false))
           else
               list.add(Mensaje(de = "Mario Cabrera", contenido = "Hola", esMio = true))
       }
        adapter = ChatRoomAdapter(list)
        rootView.rvGroupChats.adapter = adapter
    }
}