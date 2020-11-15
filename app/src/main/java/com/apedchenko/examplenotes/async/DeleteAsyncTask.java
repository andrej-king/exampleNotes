package com.apedchenko.examplenotes.async;

import android.os.AsyncTask;
import android.util.Log;

import com.apedchenko.examplenotes.models.Note;
import com.apedchenko.examplenotes.persistence.NoteDAO;

public class DeleteAsyncTask extends AsyncTask<Note, Void, Void> {

	private NoteDAO mNoteDao;

	public DeleteAsyncTask(NoteDAO dao) {
		mNoteDao = dao;
	}

	@Override
	protected Void doInBackground(Note... notes) {
		mNoteDao.delete(notes);
		return null;
	}
}
