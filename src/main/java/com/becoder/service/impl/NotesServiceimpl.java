package com.becoder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.becoder.entity.Notes;
import com.becoder.entity.User;
import com.becoder.repository.NotesRepository;
import com.becoder.service.NotesService;

@Service
public class NotesServiceimpl implements NotesService 
{
	
	@Autowired
	private NotesRepository notesRepository;
	@Override
	public Notes saveNotes(Notes notes) 
	{		
		return notesRepository.save(notes);
	}

	@Override
	public Notes getNotesById(int id) 
	{
		return notesRepository.findById(id).get();
	}

	@Override
	public Page<Notes> getNotesByUser(User user, int pageNo) 
	{
		Pageable pageable = PageRequest.of(pageNo, 5);
		
		return notesRepository.findByUser(user, pageable);
	}
	
	
	@Override
	public Notes updateNotes(Notes notes) 
	{
		return notesRepository.save(notes);
	}

	@Override
	public boolean deleteNotes(int id) 
	{
		Notes notes = notesRepository.findById(id).get();
		
		if (notes!=null)
		{
			notesRepository.delete(notes);
			return true;
		} 
		return false;
	}

	

}
