package com.universae.memy.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.universae.memy.adapters.NoteAdapter
import com.universae.memy.database.MemyDatabase
import com.universae.memy.databinding.FragmentNotesBinding
import com.universae.memy.viewModel.NoteVM
import com.universae.memy.viewModelFactory.NoteVMF


class NotesFragment : Fragment() {
    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNotesBinding.inflate(inflater,container,false)
        val view = binding.root
        val application = requireNotNull(this.activity).application
        val daoNote = MemyDatabase.getInstance(application).noteInt
        val viewModelFactory = NoteVMF(daoNote)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(NoteVM::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = NoteAdapter()
        binding.notesList.adapter = adapter

        viewModel.notes.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
