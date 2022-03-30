package com.shahi.noteskotlinapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.shahi.noteskotlinapp.databinding.FragmentCreateBinding
import com.shahi.noteskotlinapp.entity.Note
import com.shahi.noteskotlinapp.viewmodel.NoteViewModel


class CreateNoteFragment : Fragment() {

    lateinit var binding: FragmentCreateBinding

    private lateinit var viewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCreateBinding.inflate(layoutInflater, container, false)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        )[NoteViewModel::class.java]


        binding.saveNoteBtn.setOnClickListener {
            createNote()
        }

        return binding.root
    }

    private fun createNote() {
        val title = binding.editTitle.text.toString()
        val subTitle = binding.editSubTitle.text.toString()
        val description = binding.editDescription.text.toString()
        val dateTime = System.currentTimeMillis().toString()

        val note = Note(
            null, title = title,
            subTitle = subTitle,
            description = description,
            dateTime = dateTime
        )
        viewModel.addNote(note)

        Toast.makeText(requireContext(), "Note created", Toast.LENGTH_SHORT).show()
    }
}