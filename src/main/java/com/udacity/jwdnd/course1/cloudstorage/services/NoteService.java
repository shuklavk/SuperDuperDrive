package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.models.Note;
import com.udacity.jwdnd.course1.cloudstorage.models.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.models.User;

@Service
public class NoteService {
	
	private NoteMapper noteMapper;
	private UserService userService;
	
	public NoteService(NoteMapper noteMapper, UserService userService) {
		this.noteMapper = noteMapper;
		this.userService = userService;
	}
	
	public List<Note> getAllNotes(String username){
		User user = this.userService.getUser(username);
		return this.noteMapper.getNotes(user.getUserid());
	}
	
	public int addNote(NoteForm note, String username) {
		int userid = this.userService.getUser(username).getUserid();
		return this.noteMapper.insertNote(new Note(null, note.getNoteTitle(),note.getNoteDescription(), userid));
	}
	
	public void deleteNote(int noteid) {
		this.noteMapper.deleteNote(noteid);
	}
	
	public int updateNode(NoteForm note, String username) {
		int userid = this.userService.getUser(username).getUserid();
		return this.noteMapper.updateNote(new Note(Integer.valueOf(note.getNoteId()), note.getNoteTitle(), note.getNoteDescription(), userid));
	}
}
