package com.personalSystem.taskManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalSystem.taskManager.entities.Task;
import com.personalSystem.taskManager.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;

	public List<Task> findAll() {
		return repository.findAll();
	}

	public Task findById(Long id) {
		Optional<Task> obj = repository.findById(id);
		return obj.get();
	}

	public Task insert(Task obj) {
		return repository.save(obj);
	}

	public Task update(Long id, Task obj) {
		Task entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Task entity, Task obj) {
		entity.setTitle(obj.getTitle());
		entity.setInitialDate(obj.getInitialDate());
		entity.setFinishDate(obj.getFinishDate());
		entity.setTaskStatus(obj.getTaskStatus());
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}

}
