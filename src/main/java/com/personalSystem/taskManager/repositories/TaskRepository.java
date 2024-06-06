package com.personalSystem.taskManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalSystem.taskManager.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	
	
}
