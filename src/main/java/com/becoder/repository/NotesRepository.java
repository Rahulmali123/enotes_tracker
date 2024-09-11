package com.becoder.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.entity.Notes;
import com.becoder.entity.User;

public interface NotesRepository extends JpaRepository<Notes, Integer>
{
	public Page<Notes> findByUser(User user,Pageable pageable);
}
