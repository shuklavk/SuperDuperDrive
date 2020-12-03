package com.udacity.jwdnd.course1.cloudstorage.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udacity.jwdnd.course1.cloudstorage.models.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;

@Controller
@RequestMapping("/notes")
public class NoteController {
	
	private NoteService noteService;
	
	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@PostMapping()
	public String addNote(@ModelAttribute NoteForm noteForm, Model model, Authentication auth) {
		if(!noteForm.getNoteId().equals("")) {
			this.noteService.updateNode(noteForm, auth.getName());
		}else {
			this.noteService.addNote(noteForm, auth.getName());
		}
		return "redirect:/"; 
	}
	
	@GetMapping("/deletenote/{noteid}")
	public String deleteNote(@PathVariable String noteid) {
		this.noteService.deleteNote(Integer.valueOf(noteid));
		return "redirect:/";
	}

}
