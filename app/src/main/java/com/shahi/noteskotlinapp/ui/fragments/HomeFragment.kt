package com.shahi.noteskotlinapp.ui.fragments

import android.graphics.drawable.GradientDrawable
import android.icu.lang.UCharacter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.shahi.noteskotlinapp.R
import com.shahi.noteskotlinapp.databinding.FragmentHomeBinding
import com.shahi.noteskotlinapp.ui.adapter.NoteAdapter
import com.shahi.noteskotlinapp.viewmodel.NoteViewModel


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    private lateinit var viewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        )[NoteViewModel::class.java]

        viewModel.getNotes().observe(viewLifecycleOwner) { noteLists ->
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            binding.recyclerView.setHasFixedSize(true)
            binding.recyclerView.adapter = NoteAdapter(noteLists)
        }

        binding.fabBtn.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_createNoteFragment)
        }

        return binding.root
    }
}