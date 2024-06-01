package com.universae.memy.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.universae.memy.adapters.TaskAdapter
import com.universae.memy.database.MemyDatabase
import com.universae.memy.databinding.FragmentTasksBinding
import com.universae.memy.viewModel.TaskVM
import com.universae.memy.viewModelFactory.TaskVMF


class TasksFragment : Fragment() {

    /*Declaramos una variable que puede ser null que contendrá el objeto que
   hará el binding con el layout del fragmento*/
    private var _binding: FragmentTasksBinding? = null

    /*Declaramos una variable con una propiedad que la obliga a no ser null y que devuelve el
    objeto _binding siendo un objeto non-null por seguridad  */
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /* Hinchamos el layout e inicializamos la variable _binding */
        _binding = FragmentTasksBinding.inflate(inflater, container, false)

        /*Asignamos la vista raíz del objeto binding a la variable view */
        val view = binding.root

        /*Nos aseguramos de que el contexto de la aplicación no sea null */
        val application = requireNotNull(this.activity).application

        /*Creamos la base de datos si no existe ya y hacemos referencia a la propiedad
        noteInt de tipo TaskDAO */
        val daoTask = MemyDatabase.getInstance(application).taskInt

        /*Creamos una instancia del ViewModelFactory pasando la interfaz NoteDAO a su constructor */
        val viewModelFactory = TaskVMF(daoTask)

        /*Conseguimos una instancia del ViewModel TaskVM a través del ViewModelFactory */
        val viewModel = ViewModelProvider(this, viewModelFactory).get(TaskVM::class.java)

        /*Unimos el ViewModel al layout de NotesFragment */
        binding.viewModel = viewModel

        /*Unimos el Lifecycle Owner del fragmento al del layout para que responda a actualizaciones
        de LiveData */
        binding.lifecycleOwner = viewLifecycleOwner

        /*Pasamos una instancia del adaptador de tipo RecyclerView NoteAdapter asignada a una variable */
        val adapter = TaskAdapter()

        /*Asignamos el adaptador al RecyclerView del layout */
        binding.tasksList.adapter = adapter

        /*Asignamos un observador a los datos LiveData del ViewModel NoteVM que actualice los datos
         del adaptador conforme se hagan cambios  */
        viewModel.tasks.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        return view
    }
    /*Indicamos que a la hora de destruir el fragmento también se deshaga el binding */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
