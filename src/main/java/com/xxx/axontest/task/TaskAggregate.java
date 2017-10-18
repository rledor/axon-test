package com.xxx.axontest.task;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventsourcing.EventSourcingHandler;

@AggregateRoot
public class TaskAggregate {
	
	private Logger logger = LogManager.getLogger(TaskCreatedEvent.class);

	@AggregateIdentifier
	private int taskId;
	private String name;
	
	@CommandHandler
	public void handleCommand(CreateTaskCommand createTaskCommand) {
		logger.info("Command received");
		AggregateLifecycle.apply(new TaskCreatedEvent());
	}
	
	@EventSourcingHandler
	public void onTaskCreatedEvent(TaskCreatedEvent taskCreatedEvent) {
		logger.info("Event received");
	}
	
	public int getTaskId() {
		return taskId;
	}
	
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
