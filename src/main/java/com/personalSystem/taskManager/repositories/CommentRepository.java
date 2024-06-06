package com.personalSystem.taskManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalSystem.taskManager.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	
	
}
