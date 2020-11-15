package com.apedchenko.examplenotes.async;

import android.os.AsyncTask;

import com.apedchenko.examplenotes.models.Note;
import com.apedchenko.examplenotes.persistence.NoteDAO;

public class UpdateAsyncTask extends AsyncTask<Note, Void, Void> {

	private NoteDAO mNoteDao;

	public UpdateAsyncTask(NoteDAO dao) {
		mNoteDao = dao;
	}

	@Override
	protected Void doInBackground(Note... notes) {
		mNoteDao.update(notes);
		return null;
	}
}
