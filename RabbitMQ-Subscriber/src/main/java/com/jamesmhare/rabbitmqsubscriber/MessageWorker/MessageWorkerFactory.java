package com.jamesmhare.rabbitmqsubscriber.MessageWorker;

/**
 * This serves as a factory for creating a new instance of the
 * {@link MessageWorkerImpl}
 * 
 * @author James Hare
 *
 */
public class MessageWorkerFactory {
	public MessageWorker createMessageWorker() {
		return new MessageWorkerImpl();
	}
}
