package com.xxx.axontest.task;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class UpdateTaskCommand {

	@TargetAggregateIdentifier
	private final int taskId;
	private final String status;
	
	public UpdateTaskCommand(int taskId, String status) {
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
