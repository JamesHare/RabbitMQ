package com.jamesmhare.rabbitmqsubscriber.MessageWorker;

/**
 * This serves as an interface for a message worker which subscribes to a
 * messaging queue to receive messages from the publisher.
 * 
 * @author James Hare
 *
 */
public interface MessageWorker {

	/**
	 * Starts the message worker.
	 */
	void startWorker();

	/**
	 * Processes the message based on the given number of periods which represent
	 * the seconds it takes to process.
	 */
	void processMessage(String message);

	/**
	 * Returns the host of the message worker as a {@link String}.
	 * 
	 * @return - The host of the message worker as a {@link String}.
	 */
	String getHost();
}
