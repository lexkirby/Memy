package com.universae.memy.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.universae.memy.database.MemyDatabase
import com.universae.memy.databinding.FragmentTasksBinding
import com.universae.memy.viewModel.TaskVM
import com.universae.memy.viewModelFactory.TaskVMF


class TasksFragment : Fragment() {
    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTasksBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val daoTask = MemyDatabase.getInstance(application).taskInt
        val viewModelFactory = TaskVMF(daoTask)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(TaskVM::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
