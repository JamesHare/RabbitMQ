package com.jamesmhare.rabbitmqpublisher.MessageTask;

/**
 * This serves as a factory for creating a new instance of the
 * {@link MessageTaskImpl}
 * 
 * @author James Hare
 *
 */
public class MessageTaskFactory {
	public MessageTask createMessageTask() {
		return new MessageTaskImpl();
	}
}
