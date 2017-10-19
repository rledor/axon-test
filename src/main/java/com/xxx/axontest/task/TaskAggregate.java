package com.xxx.axontest.task;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class TaskAggregate {
	
	private Logger logger = LogManager.getLogger(TaskCreatedEvent.class);

	@AggregateIdentifier
	private int taskId;
	private String status;
	
	public TaskAggregate() {}
	
	@CommandHandler
	public TaskAggregate(CreateTaskCommand command) {
		logger.info("CreateTaskCommand received");
		this.taskId = command.getTaskId();
		apply(new TaskCreatedEvent(command.getTaskId(), "created"));
	}
	
	@CommandHandler
	public void handle(UpdateTaskCommand command) {
		logger.info("UpdateTaskCommand received ");
		apply(new TaskUpdatedEvent(command.getTaskId(), command.getStatus()));
	}
	
	
	@EventSourcingHandler
	public void on(TaskCreatedEvent event) {
		logger.info("TaskCreatedEvent received: " + event.getStatus());
		this.taskId = event.getTaskId();
		this.status = event.getStatus();
	}
	
	@EventSourcingHandler
	public void on(TaskUpdatedEvent event) {
		logger.info("TaskUpdatedEvent received: " + event.getStatus());
		this.status = event.getStatus();
	}
	
}
