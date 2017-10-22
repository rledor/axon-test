package com.xxx.axontest.cmd.task;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CreateTaskCommand {

	@TargetAggregateIdentifier
	private int taskId;
	
	public CreateTaskCommand(int taskId) {
		this.taskId = taskId;
	}

	public int getTaskId() {
		return taskId;
	}
	
}
