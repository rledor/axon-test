package com.xxx.axontest.task;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CreateTaskCommand {

	@TargetAggregateIdentifier
	private int taskId;
	private String name;
	
	public CreateTaskCommand(int taskId, String name) {
		super();
		this.taskId = taskId;
		this.name = name;
	}

	public int getTaskId() {
		return taskId;
	}
	
	public String getName() {
		return name;
	}
	
}
