package com.personalSystem.taskManager.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.personalSystem.taskManager.entities.Comment;
import com.personalSystem.taskManager.entities.Task;
import com.personalSystem.taskManager.entities.enums.TaskStatus;
import com.personalSystem.taskManager.repositories.CommentRepository;
import com.personalSystem.taskManager.repositories.TaskRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Task t1 = new Task("I need to go to the bar in this night", Instant.now(),TaskStatus.NOT_STARTED);
		Task t2 = new Task("I need to study in this night", Instant.now(),TaskStatus.IN_PROGRESS);
		taskRepository.saveAll(Arrays.asList(t1,t2));
		
		Comment c1 = new Comment("I doing my best to get all i need to be complete", t2);
		
		commentRepository.save(c1);
		

		
	}

}
