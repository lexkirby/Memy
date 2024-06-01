package com.universae.memy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.universae.memy.R
import com.universae.memy.taskData.Task

/* Creamos una clase que extiende del adaptador de Recycler View que la convierte en adaptador y le
indicamos que trabaje con su clase interna ViewHolder */
class TaskAdapter: RecyclerView.Adapter<TaskAdapter.TaskItemViewHolder>() {
    /*Creamos una variable con la lista de tareas y le añadimos un setter personalizado que avisará
    al adaptador de que han cambiado los datos para que pueda repintarse */
    var data = listOf<Task>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    /*Sobreescribimos el método para contabilizar los datos de la lista para que el adaptador sepa
    cuantos mostrar */
    override fun getItemCount() = data.size

    /*Creamos un método que se llamará cuando RecyclerView necesite un nuevo ViewHolder para
       representar un dato de la lista y hará que se hinche el view del item del XML task_item.xml*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            TaskItemViewHolder = TaskItemViewHolder.inflateFrom(parent)

    /*Creamos un método para mostrar datos de posiciones determinadas uniendo los datos de los items
    de Task a las vistas del ViewHolder */
    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    /*Creamos clase interna ViewHolder que contiene la vista raíz del layout de cada dato de la lista, en este caso
    un CardView */
    class TaskItemViewHolder(val rootView: CardView) : RecyclerView.ViewHolder(rootView) {
        /*Asignamos a variables el TextView y el CheckBox de item_item.xml para el nombre de la tarea
        y su estado de compleción*/
            val taskName = rootView.findViewById<TextView>(R.id.task_name)
            val taskDone = rootView.findViewById<CheckBox>(R.id.task_done)

        /*Metemos dentro del companion object un método para poder llamarlo sin haber creado un objeto
         de la clase TaskItemViewHolder*/
        companion object {

            /*Definimos un método que hincha el layout de note_item.xml lo asigna al tipo CardView y lo
             devuelve como un nuevo ViewHolder con el layout hinchado como parámetro */
            fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.task_item, parent, false) as CardView
                return TaskItemViewHolder(view)
            }
        }
        /*Creamos un método que une los datos de un objeto Note a los views del layout task_item.xml*/
        fun bind(item: Task) {
            taskName.text = item.taskName
            taskDone.isChecked = item.taskDone


        }
    }
}