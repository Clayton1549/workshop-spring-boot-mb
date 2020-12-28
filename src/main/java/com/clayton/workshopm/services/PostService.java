package com.clayton.workshopm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clayton.workshopm.domain.Post;
import com.clayton.workshopm.repository.PostReposiory;
import com.clayton.workshopm.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostReposiory repo;

	
	public Optional<Post> findById(String id) {
		
		Optional<Post> user= repo.findById(id);
		
		if (user ==  null) {
		throw new  ObjectNotFoundException("Objeto não encontrado");
		
		}
		
		return user;
	}

	public List<Post> findByTitle(String text) {
		
		return  repo.searchTitle(text);
	}
}