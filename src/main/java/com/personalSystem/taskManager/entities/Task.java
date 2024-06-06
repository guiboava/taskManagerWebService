package com.personalSystem.taskManager.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.personalSystem.taskManager.entities.enums.TaskStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_task")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant initialDate;

	private Instant finishDate;

	private Integer taskStatus;

	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comment;

	public Task() {

	}

	public Task(String title, Instant initialDate, TaskStatus taskStatus) {
		super();
		this.title = title;
		this.initialDate = initialDate;
		setTaskStatus(taskStatus);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instant getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Instant finishDate) {
		this.finishDate = finishDate;
	}

	public TaskStatus getTaskStatus() {
		return TaskStatus.valueOf(taskStatus);
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		if (taskStatus != null) {
			this.taskStatus = taskStatus.getCode();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Instant initialDate) {
		this.initialDate = initialDate;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(id, other.id);
	}

}
