package com.xxx.axontest.task;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class TaskCreatedEvent {

	@TargetAggregateIdentifier
	private int taskId;
	private String name;

	public int getTaskId() {
		return taskId;
	}
	
	public String getName() {
		return name;
	}
	
}
