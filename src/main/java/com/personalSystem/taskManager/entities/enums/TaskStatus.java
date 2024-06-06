package com.personalSystem.taskManager.entities.enums;

public enum TaskStatus {
	NOT_STARTED(1), IN_PROGRESS(2), CANCELLED(3), DONE(4);

	private int code;
	
	private TaskStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static TaskStatus valueOf(int code) {
		for (TaskStatus value : TaskStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid TaskStatus code");
	}
}
