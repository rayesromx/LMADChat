package com.fcfm.poi.plantilla.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fcfm.poi.plantilla.R
import com.fcfm.poi.plantilla.adapters.ChatRoomAdapter
import com.fcfm.poi.plantilla.adapters.GroupChatAdapter
import com.fcfm.poi.plantilla.models.GroupChat
import com.fcfm.poi.plantilla.models.Mensaje
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
        rootView = inflater.inflate(R.layout.fragment_chat_room, container, false)
        loadMensajes()
        return rootView
    }

    private fun loadMensajes() {
        for (i in 1..10)
            list.add(Mensaje(de = "Mario Cabrera", contenido = "Hola"))
        adapter = ChatRoomAdapter(list)
        rootView.rvGroupChats.adapter = adapter
    }

}