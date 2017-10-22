package com.xxx.axontest.cmd.task;

public class TaskCreatedEvent {

	private final int taskId;
	private final String status;
	
	public TaskCreatedEvent(int taskId, String status) {
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
