package com.shahi.noteskotlinapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shahi.noteskotlinapp.databinding.ItemNoteBinding
import com.shahi.noteskotlinapp.entity.Note
import com.shahi.noteskotlinapp.ui.viewholder.NoteViewHolder

class NoteAdapter(val noteLists: List<Note>) :
    RecyclerView.Adapter<NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        var note = noteLists[position]
        holder.binding.noteTitle.text = note.title
        holder.binding.noteDescription.text = note.description
        holder.binding.noteDate.text = note.dateTime
    }

    override fun getItemCount(): Int {
        return noteLists.size
    }
}
