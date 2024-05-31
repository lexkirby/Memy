package com.universae.memy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.universae.memy.R
import com.universae.memy.notesData.Note

/* Creamos clase que extiende del adaptador de Recycler View que la convierte en adaptador y le indicamos
  que trabaje con su clase interna ViewHolder */
class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteItemViewHolder>() {

    //Creamos una variable con la lista de notas y le añadimos un setter personalizado que avisará
    //al adaptador de que han cambiado los datos para que pueda repintarse
    var data = listOf<Note>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    /*Sobreescribimos el método para contabilizar los datos de la lista para que el adaptador sepa
     cuantos mostrar */
    override fun getItemCount() = data.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            NoteItemViewHolder = NoteItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    /*Creamos clase interna ViewHolder que contiene la vista raíz del layout de cada dato de la lista, en este caso
     un TextView */
    class NoteItemViewHolder(val rootView: CardView) : RecyclerView.ViewHolder(rootView) {
        val noteName = rootView.findViewById<TextView>(R.id.note_Title)
        val noteContent = rootView.findViewById<TextView>(R.id.note_Content)
        companion object {

            fun inflateFrom(parent: ViewGroup): NoteItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.note_item, parent, false) as CardView
                return NoteItemViewHolder(view)
            }
        }
            fun bind(item: Note) {
                noteName.text = item.noteName
                noteContent.text = item.noteContent
            }
        }
    }



