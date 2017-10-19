package com.xxx.axontest.task;

public class TaskUpdatedEvent {

	private final int taskId;
	private final String status;
	
	public TaskUpdatedEvent(int taskId, String status) {
		this.taskId = taskId;
		this.status = status;
	}

	public int getTaskId() {
		return taskId;
	}

	public String getStatus() {
		return status;
	}

}
