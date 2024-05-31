package com.universae.memy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.universae.memy.R
import com.universae.memy.taskData.Task


class TaskAdapter: RecyclerView.Adapter<TaskAdapter.TaskItemViewHolder>() {
    //Creamos una variable con la lista de tareas y le añadimos un setter personalizado que avisará
    //al adaptador de que han cambiado los datos para que pueda repintarse
    var data = listOf<Task>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    /*Creamos clase interna ViewHolder que contiene la vista raíz del layout de cada dato de la lista, en este caso
     un TextView */
    class TaskItemViewHolder(val rootView: CardView) : RecyclerView.ViewHolder(rootView) {
            val taskName = rootView.findViewById<TextView>(R.id.task_name)
            val taskDone = rootView.findViewById<CheckBox>(R.id.task_done)
        companion object {

            fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.task_item, parent, false) as CardView
                return TaskItemViewHolder(view)
            }
        }
        fun bind(item: Task) {
            taskName.text = item.taskName
            taskDone.isChecked = item.taskDone


        }
    }
}