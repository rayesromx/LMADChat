package com.fcfm.poi.plantilla.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fcfm.poi.plantilla.R
import com.fcfm.poi.plantilla.adapters.AlertAdapter
import com.fcfm.poi.plantilla.adapters.ChatAlertAdapter
import com.fcfm.poi.plantilla.adapters.TaskAdapter
import com.fcfm.poi.plantilla.fragments.dummy.DummyContent
import com.fcfm.poi.plantilla.models.Alert
import com.fcfm.poi.plantilla.models.ChatAlert
import com.fcfm.poi.plantilla.models.Task
import kotlinx.android.synthetic.main.fragment_chat.view.*
import kotlinx.android.synthetic.main.fragment_task_list.view.*

/**
 * A fragment representing a list of Items.
 */
class FragmentTask : Fragment() {


    private lateinit var rootView: View
    private lateinit var taskAdapter: TaskAdapter
    private val taskList = mutableListOf<Task>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_task_list, container, false)

        // Set the adapter
        for (i in 0..10)
            taskList.add(Task("tarea $i", "Tarea pendiente"))

        taskAdapter = TaskAdapter(taskList)
        rootView.rvTasks.adapter = taskAdapter

        return rootView
    }


}