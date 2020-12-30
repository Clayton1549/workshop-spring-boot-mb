package com.clayton.workshopm.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.clayton.workshopm.domain.Post;
import com.clayton.workshopm.domain.User;
import com.clayton.workshopm.dto.AuthorDTO;
import com.clayton.workshopm.dto.CommentDTO;
import com.clayton.workshopm.repository.PostReposiory;
import com.clayton.workshopm.repository.UserReposiory;

@Configuration
public class Instantaction implements CommandLineRunner{
	
	@Autowired
	private UserReposiory userRepository;
	
	@Autowired
	private PostReposiory postRepository;


	@Override
	public void run(String... args) throws Exception {
		  SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
		  sdf .setTimeZone(TimeZone.getTimeZone("GNT"));
		   
		  userRepository.deleteAll();
		  postRepository.deleteAll();
		
		   User maria = new User(null, "Maria Brown", "maria@gmail.com"); 
		   User alex = new User(null, "Alex Green", "alex@gmail.com"); 
		   User bob = new User(null, "Bob Grey", "bob@gmail.com"); 
		   
		   
		   userRepository.saveAll(Arrays.asList(maria,alex,bob));
		   
		   
		   Post post1   = new Post(null, sdf.parse("21/03/2019"), "Partiu  Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		   Post postc   = new Post(null, sdf.parse("21/03/2019"), "bom dia" ,"Acordei ou nao feliz hoje? " , new AuthorDTO(maria));
          
		   CommentDTO c1 = new  CommentDTO("Boa viagem mano", sdf.parse("21/03/2019"), new  AuthorDTO(alex));
		   CommentDTO c2 = new  CommentDTO("Aproveite", sdf.parse("22/03/2019"), new  AuthorDTO(bob));
		   CommentDTO c3 = new  CommentDTO("Tenha  um bom dia", sdf.parse("23/03/2019"), new  AuthorDTO(alex));
		   
		   post1.getComments().addAll(Arrays.asList(c1,c2));
		   postc.getComments().addAll(Arrays.asList(c3));
		   
		  
		   postRepository.saveAll(Arrays.asList(post1,postc));
		   
		   
		   maria.getPosts().addAll(Arrays.asList(post1, postc));
		   userRepository.save(maria);
		   
		   
		  
					
					
		}
 
}
