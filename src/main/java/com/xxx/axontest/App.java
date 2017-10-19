package com.xxx.axontest;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.mongo.eventsourcing.eventstore.DefaultMongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.mongodb.MongoClient;
import com.xxx.axontest.task.CreateTaskCommand;
import com.xxx.axontest.task.UpdateTaskCommand;

@SpringBootApplication
public class App {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(App.class, args);
		CommandGateway commandGateway = configurableApplicationContext.getBean(CommandGateway.class);
		commandGateway.send(new CreateTaskCommand(123));
		commandGateway.send(new UpdateTaskCommand(123, "started"));
		commandGateway.send(new UpdateTaskCommand(123, "completed"));
	}

	@Bean
	public EventStorageEngine eventStorageEngine(MongoClient mongoClient) {
		return new MongoEventStorageEngine(new DefaultMongoTemplate(mongoClient));
	}
	
}
