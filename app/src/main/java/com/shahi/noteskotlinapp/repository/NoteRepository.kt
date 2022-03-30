package com.shahi.noteskotlinapp.repository

import androidx.lifecycle.LiveData
import com.shahi.noteskotlinapp.dao.NoteDao
import com.shahi.noteskotlinapp.entity.Note

class NoteRepository(private val dao: NoteDao) {

    fun getAllNotes(): LiveData<List<Note>> {
        return dao.getAllNotes()
    }

    suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }

    suspend fun updateNote(note: Note) {
        return dao.updateNote(note)
    }
}