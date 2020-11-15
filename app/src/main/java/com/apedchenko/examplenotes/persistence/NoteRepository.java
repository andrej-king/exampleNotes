package com.apedchenko.examplenotes.persistence;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.apedchenko.examplenotes.async.DeleteAsyncTask;
import com.apedchenko.examplenotes.async.InsertAsyncTask;
import com.apedchenko.examplenotes.async.UpdateAsyncTask;
import com.apedchenko.examplenotes.models.Note;

import java.util.List;

public class NoteRepository {

	private NoteDatabase mNoteDatabase;

	public NoteRepository(Context context) {
		mNoteDatabase = NoteDatabase.getInstance(context);
	}

	public void insertNoteTask(Note note) {
		new InsertAsyncTask(mNoteDatabase.getNoteDao()).execute(note); // execute - start async task
	}

	public void updateNote(Note note) {
		new UpdateAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
	}

	public LiveData<List<Note>> retrieveNoteTask() {
		return mNoteDatabase.getNoteDao().getNotes();
	}

	public void deleteNote(Note note) {
		new DeleteAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
	}
}
