package com.jamesmhare.rabbitmqpublisher.application;

import com.jamesmhare.rabbitmqpublisher.BasicSender.BasicSender;
import com.jamesmhare.rabbitmqpublisher.BasicSender.BasicSenderFactory;
import com.jamesmhare.rabbitmqpublisher.MessageTask.MessageTask;
import com.jamesmhare.rabbitmqpublisher.MessageTask.MessageTaskFactory;

/**
 * This will serve as an entry point for the RabbitMQ Publisher application.
 * 
 * @author James Hare
 *
 */
public class Application {

	private static BasicSender basicSender;
	private static BasicSenderFactory basicSenderFactory;
	private static MessageTask messageTask;
	private static MessageTaskFactory messageTaskFactory;

	public static void main(String[] args) throws Exception {
		messageTaskFactory = new MessageTaskFactory();
		messageTask = messageTaskFactory.createMessageTask();
		messageTask.startMessageTask();
	}

}
